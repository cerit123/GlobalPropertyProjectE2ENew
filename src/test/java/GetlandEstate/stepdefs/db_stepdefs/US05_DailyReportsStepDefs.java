package GetlandEstate.stepdefs.db_stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US05_DailyReportsStepDefs {
    private ResultSet resultSet;
    private List<String> expectedColumnNames;
    private List<String> actualColumnNames;

    /**
     * Define expected column names for validation.
     */
    @And("Beklenen sutun isimleri düzenlenir")
    public void beklenenSutunIsimleriDüzenlenir() {
        expectedColumnNames = Arrays.asList(
                "id", "date", "number_of_contact_message", "number_of_favorites",
                "number_of_rent_adverts", "number_of_sale_adverts", "number_of_tour_requests", "number_of_users"
        );
    }

    /**
     * Retrieve column names from the database.
     */
    @When("Sutun isimlerini almak için query gönderilir")
    public void sutunIsimleriniAlmakIçinQueryGönderilir() throws SQLException {
        Statement statement = US01_TabloİsimleriniDoğrulaStepdefs.connection.createStatement(
                ResultSet.TYPE_FORWARD_ONLY, // Forward-only to avoid PostgreSQL scrollable issues
                ResultSet.CONCUR_READ_ONLY
        );

        resultSet = statement.executeQuery(
                "SELECT column_name " +
                        "FROM information_schema.columns " +
                        "WHERE table_schema = 'public' AND table_name = 'daily_reports'"
        );

        // Store column names in a list
        actualColumnNames = new ArrayList<>();
        while (resultSet.next()) {
            actualColumnNames.add(resultSet.getString("column_name"));
        }
    }

    /**
     * Validate retrieved column names against expected values.
     */
    @Then("Sutun isimleri dogrulanır")
    public void sutunIsimleriDogrulanır() {
        // Debugging output
        System.out.println("Expected Columns: " + expectedColumnNames);
        System.out.println("Actual Columns: " + actualColumnNames);

        // Assertion: Check if expected and actual column names match
        Assert.assertEquals("Column names do not match!", expectedColumnNames, actualColumnNames);
    }

    /**
     * Query the database for specific record IDs.
     */
    @When("{int}{int} id numarali Sutun isimlerini almak için query gönderilir")
    public void idNumaraliSutunIsimleriniAlmakIçinQueryGönderilir(int arg0, int arg1) throws SQLException {
        Statement statement = US01_TabloİsimleriniDoğrulaStepdefs.connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM daily_reports WHERE id IN (10, 11)");
    }

    /**
     * Verify that records with the given IDs exist.
     */
    @Then("{int}{int} id numarali kayitlarin oldugu dogrulanir")
    public void idNumaraliKayitlarinOlduguDogrulanir(int arg0, int arg1) {
        try {
            // Create a statement with a scrollable ResultSet
            Statement statement = US01_TabloİsimleriniDoğrulaStepdefs.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,  // This makes the ResultSet scrollable
                    ResultSet.CONCUR_READ_ONLY         // Read-only result set- Olmasa da olur.
                    // If you don't care about read-only or updatable behavior, you can skip it and it will default
                    // to read-only:
            );

            // Execute the query to retrieve the rows
            resultSet = statement.executeQuery("SELECT * FROM daily_reports WHERE id IN (10, 11)");

            // Reset cursor position before reading the result set
            resultSet.beforeFirst();
            boolean recordExists = false;

            while (resultSet.next()) {
                // Check if the ID matches 10 or 11
                int id = resultSet.getInt("id");
                System.out.println("Checking ID: " + id);  // Debugging output
                if (id == 10 || id == 11) {
                    recordExists = true;
                }
            }

            if (!recordExists) {
                throw new RuntimeException("Records with IDs 10 and 11 do not exist!");
            }

            // If we reach here, the IDs were found
            System.out.println("Records with IDs 10 and 11 were found.");
        } catch (SQLException e) {
            // Print stack trace for better debugging
            e.printStackTrace();
            throw new RuntimeException("Error checking record existence", e);
        }
    }


}


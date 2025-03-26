package GetlandEstate.stepdefs.db_stepdefs;

import GetlandEstate.utilities.ConfigReader;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.sql.*;
import java.util.*;

public class US17_UsersTableStepDefs {

    Connection connection;
    ResultSet resultSet;
    List<String> expectedUsersColumnNames;
    List<String> expectedUserRow;

    @Given("users tablosu icin Database bağlantısı kurulur")
    public void databaseBaglantisiKurulur() throws SQLException {
        connection = DriverManager.getConnection(
                ConfigReader.getProperty("dbUrl"),
                ConfigReader.getProperty("dbUsername"),
                ConfigReader.getProperty("dbPassword")
        );
    }

    @And("Expected users datalar duzenlenir")
    public void expectedUsersDatalarDuzenlenir() {
        expectedUsersColumnNames = Arrays.asList(
                "id", "created_at", "updated_at", "built_in", "email", "enabled",
                "first_name", "last_name", "locked", "password_hash", "phone",
                "reset_password_code", "role", "picture_id"
        );


        expectedUserRow = Arrays.asList("1", "admin@gmail.com", "John", "Doe", "(123) 456-7890", "ADMIN");
    }

    @When("users tablosu sutun isimlerini almak icin query gonderilir")
    public void usersTablosuKolonIsimleriniAlmakIcinQueryGonderilir() throws SQLException {
        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery(
                "SELECT column_name FROM information_schema.columns WHERE table_name = 'users';"
        );
    }

    @Then("users tablosu sutun isimleri dogrulanir")
    public void usersTablosuKolonIsimleriDogrulanir() throws SQLException {
        List<String> actualUsersColumnNames = new ArrayList<>();

        while (resultSet.next()) {
            actualUsersColumnNames.add(resultSet.getString("column_name"));
        }

        System.out.println("Expected Columns: " + expectedUsersColumnNames);
        System.out.println("Actual Columns:   " + actualUsersColumnNames);

        Assert.assertTrue("Sütun isimleri eşleşmiyor!",
                actualUsersColumnNames.containsAll(expectedUsersColumnNames) &&
                        expectedUsersColumnNames.containsAll(actualUsersColumnNames));
    }

    @When("users tablosu sutun bilgileri sorgulanır")
    public void usersTablosuSutunBilgileriSorgulanir() {
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(
                    "SELECT id, email, first_name, last_name, phone, role FROM users WHERE id = 1;"
            );
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Veri çekme sırasında hata oluştu");
        }
    }

    @Then("users tablosu sutun bilgileri dogrulanir")
    public void usersTablosuSutunBilgileriDogrulanir() {
        try {
            if (resultSet.next()) {
                List<String> actualRow = new ArrayList<>();
                actualRow.add(String.valueOf(resultSet.getLong("id")));
                actualRow.add(resultSet.getString("email"));
                actualRow.add(resultSet.getString("first_name"));
                actualRow.add(resultSet.getString("last_name"));
                actualRow.add(resultSet.getString("phone"));
                actualRow.add(resultSet.getString("role"));


                Assert.assertEquals("Veri uyuşmuyor!", expectedUserRow, actualRow);
            } else {
                Assert.fail("id=1 olan kullanıcı bulunamadı.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Veri doğrulama sırasında hata oluştu");
        }
    }
}
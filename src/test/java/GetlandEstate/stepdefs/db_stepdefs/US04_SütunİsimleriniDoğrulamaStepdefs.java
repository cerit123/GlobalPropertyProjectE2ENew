package GetlandEstate.stepdefs.db_stepdefs;

import GetlandEstate.utilities.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US04_SütunİsimleriniDoğrulamaStepdefs {

    public static Connection connection;
    ResultSet resultSet;
    List<String> expectedTableNames;
    List<String> actualTableNames;
    Statement statement;
    private Object id1;

    @Given("Veritabanına bağlanılır.")
    public void veritabanınaBağlanılır() throws SQLException {

        connection = DriverManager.getConnection(ConfigReader.getProperty("dbUrl"),
                ConfigReader.getProperty("dbUsername"), ConfigReader.getProperty("dbPassword"));
    }

    @When("Contacts sütun tablosu çağrılır")
    public void contactsSütunTablosuÇağrılır() {

        expectedTableNames = Arrays.asList(
                "id, created_at,email,first_name,last_name,message,status"
        );
    }

    @And("Contacts sütundaki veriler eksiksiz gelmeli")
    public void contactsSütundakiVerilerEksiksizGelmeli() throws SQLException {

        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from contacts");

        actualTableNames = new ArrayList<>();

        while (resultSet.next()) {
            actualTableNames.add(resultSet.getString("contacts"));
        }
    }

    @Then("Database bağlantısı kapatılır.")
    public void databaseBağlantısıKapatılır() throws SQLException {

        connection.close();
        statement.close();
        resultSet.close();
    }

    // TC_02--------------------------------------------------


    @When("Contacts tablosunun id, created_at,email,first_name,last_name,message,status sütunları getirilir.")
    public void contactsTablosununIdCreated_atEmailFirst_nameLast_nameMessageStatusSütunlarıGetirilir() throws SQLException {


        resultSet = statement.executeQuery("SELECT id, created_at, email,first_name,last_name,message,status FROM contacts");

        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("id") +
                    ", Created At: " + resultSet.getTimestamp("created_at") +
                    ", Email: " + resultSet.getString("email") +
                    ", First Name: " + resultSet.getString("first_name") +
                    ", Last Name: " + resultSet.getString("last_name") +
                    ", Message: " + resultSet.getString("message") +
                    ", Status: " + resultSet.getString("status"));
        }


    }

    @And("Contacts tablosundan {int} , {int} id numaralı sütunlar çağrılır.")
    public void contactsTablosundanIdNumaralıSütunlarÇağrılır(int arg0, int arg1) throws SQLException {

        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM contacts WHERE id IN (2409, 2013)");
        int id1 = 2409;
        pstmt.setInt(1, id1);
        int id2 = 2413;
        pstmt.setInt(2, id2);
        resultSet = pstmt.executeQuery();



        while (resultSet.next()) {

        try {
            System.out.println("ID: " + resultSet.getInt("id") +
                    ", Created At: " + resultSet.getTimestamp("created_at") +
                    ", Email: " + resultSet.getString("email") +
                    ", First Name: " + resultSet.getString("first_name") +
                    ", Last Name: " + resultSet.getString("last_name") +
                    ", Message: " + resultSet.getString("message") +
                    ", Status: " + resultSet.getString("status"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        }
}



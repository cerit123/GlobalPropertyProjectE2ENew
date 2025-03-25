package GetlandEstate.stepdefs.db_stepdefs;

import GetlandEstate.utilities.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US07_SütunİsimleriDoğrulanırStepdefs {

    public static Connection connection;
    ResultSet resultSet;
    List<String> expectedTableNames;
    List<String> actualTableNames;
    Statement statement;
    private Object id1;


    @Given("Veritabanına bağlanılır")
    public void veritabanınaBağlanılır() throws SQLException {

        connection = DriverManager.getConnection(ConfigReader.getProperty("dbUrl"),
                ConfigReader.getProperty("dbUsername"), ConfigReader.getProperty("dbPassword"));
    }

    @When("Countries sütun tablosu çağrılır")
    public void countriesSütunTablosuÇağrılır() {

        expectedTableNames = Arrays.asList(
                "id ,lat,Ing,name"
        );
    }

    @And("Countries sütundaki veriler eksiksiz gelmeli")
    public void countriesSütundakiVerilerEksiksizGelmeli() throws SQLException {


        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from countries");


        actualTableNames = new ArrayList<>();

        while (resultSet.next()) {
            actualTableNames.add(resultSet.getString("countries"));


            //Assert.assertEquals(expectedTableNames,resultSet.getString("countries"));
            //Assert.assertEquals(actualTableNames,resultSet.getString("countries"));

            //Assert.assertEquals("John Doe", resultSet.getString("contacts"));
            Assert.assertTrue(actualTableNames.contains("John Doe"));
            Assert.assertTrue(actualTableNames.contains("John Doe"));
            //Assert.assertEquals("Beklenen Değer", resultSet.getString("contacts"));
        }


    }

    @Then("Database Bağlantısı kapatılır.")
    public void databaseBağlantısıKapatılır() throws SQLException {

        connection.close();
        statement.close();
        resultSet.close();
    }

    // TC_02---------------------------------------------------

    @When("Countries tablosunun id ,lat,Ing,name sütunları getirilir.")
    public void countriesTablosununIdLatIngNameSütunlarıGetirilir() throws SQLException {

        resultSet = statement.executeQuery("SELECT id, lat, lng, name FROM countries");

        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("id") +
                    ", Lat: " + resultSet.getDouble("lat") +
                    ", Lng: " + resultSet.getDouble("lng") +
                    ", Name: " + resultSet.getString("name"));
        }
    }

    @And("Countriestablosundan {int} , {int} id numaralı sütunlar çağrılır.")
    public void countriestablosundanIdNumaralıSütunlarÇağrılır(int arg0, int arg1) throws SQLException {

        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM countries WHERE id IN (230, 75)");
        int id1 = 230;
        pstmt.setInt(1, id1);
        int id2 = 75;
        pstmt.setInt(2, id2);
        resultSet = pstmt.executeQuery();

        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("id") +
                    ", Lat: " + resultSet.getDouble("lat") +
                    ", Lng: " + resultSet.getDouble("lng") +
                    ", Name: " + resultSet.getString("name"));


            //Assert.assertEquals(expectedData.id,resultSet1.getInt("id"));

            Assert.assertTrue(actualTableNames.contains("John Doe"));
            Assert.assertTrue(actualTableNames.contains("John Doe"));
        }
    }
}

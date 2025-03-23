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

public class US13_ProfilePhotosStepDefs {
    Connection connection;
    List<String> expectedProfileColumnNames;
    ResultSet resultSet;
    List<String> actualProfileColumnNames;


    @Given("Database bağlantısı kurulur")
    public void databaseBağlantısıKurulur() throws SQLException {
        connection = DriverManager.getConnection(ConfigReader.getProperty("dbUrl"), ConfigReader.getProperty("dbUsername"), ConfigReader.getProperty("dbPassword"));
    }

    @And("Expected profile_photos data lar duzenlenir")
    public void expectedProfile_photosDataLarDuzenlenir() {
        expectedProfileColumnNames = Arrays.asList(
                "id","data","name","type"
        );
    }


    @When("profile_photos tablosu sutun isimlerini almak icin query gonderilir")
    public void profile_photosTablosuSutunIsimleriniAlmakIcinQueryGonderilir() throws SQLException {
        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT column_name FROM information_schema.columns WHERE table_name = 'profile_photos';");
    }

    @Then("profile_photos tablosu sutun isimleri dogrulanir")
    public void profile_photosTablosuSutunIsimleriDogrulanir() {
        actualProfileColumnNames = new ArrayList<>();
    }


}

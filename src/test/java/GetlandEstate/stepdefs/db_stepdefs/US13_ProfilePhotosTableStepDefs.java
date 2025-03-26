package GetlandEstate.stepdefs.db_stepdefs;

import GetlandEstate.utilities.ConfigReader;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.sql.*;
import java.util.*;

public class US13_ProfilePhotosTableStepDefs {

    Connection connection;
    ResultSet resultSet;
    List<String> expectedColumnNames;
    List<String> expectedProfilePhotoRow; // Sadece tek satır

    @Given("Profile_photos tablosunu icin Database bağlantısı kurulur")
    public void databaseBaglantisiKurulur() throws SQLException {
        connection = DriverManager.getConnection(
                ConfigReader.getProperty("dbUrl"),
                ConfigReader.getProperty("dbUsername"),
                ConfigReader.getProperty("dbPassword")
        );
    }

    @And("Expected profile_photos data lar duzenlenir")
    public void expectedProfile_photosDataLarDuzenlenir() {
        expectedColumnNames = Arrays.asList("id", "data", "name", "type");

        expectedProfilePhotoRow = Arrays.asList("52", "1147446", "cropped-image.jpg", "image/jpeg");
    }

    @When("profile_photos tablosu sutun isimlerini almak icin query gonderilir")
    public void profile_photosTablosuSutunIsimleriniAlmakIcinQueryGonderilir() throws SQLException {
        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery(
                "SELECT column_name FROM information_schema.columns WHERE table_name = 'profile_photos';"
        );
    }

    @Then("profile_photos tablosu sutun isimleri dogrulanir")
    public void profile_photosTablosuSutunIsimleriDogrulanir() throws SQLException {
        List<String> actualColumnNames = new ArrayList<>();
        while (resultSet.next()) {
            actualColumnNames.add(resultSet.getString("column_name"));
        }

        System.out.println("Expected Columns: " + expectedColumnNames);
        System.out.println("Actual Columns:   " + actualColumnNames);

        Assert.assertTrue("Sütun isimleri eşleşmiyor!",
                actualColumnNames.containsAll(expectedColumnNames) &&
                        expectedColumnNames.containsAll(actualColumnNames));
    }

    @When("profile_photos tablosu sutun bilgilerini almak icin query gonderilir")
    public void profile_photosTablosuSutunBilgileriniAlmakIcinQueryGonderilir() {
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id, data, name, type FROM profile_photos WHERE id = 52;");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Veri sorgularken hata oluştu.");
        }
    }

    @Then("profile_photos tablosu sutun bilgileri dogrulanir")
    public void profile_photosTablosuSutunBilgileriDogrulanir() {
        try {
            if (resultSet.next()) {
                List<String> actualRow = new ArrayList<>();
                actualRow.add(String.valueOf(resultSet.getLong("id")));

                Object dataObj = resultSet.getObject("data");
                actualRow.add(dataObj != null ? dataObj.toString() : null);

                actualRow.add(resultSet.getString("name"));
                actualRow.add(resultSet.getString("type"));

                Assert.assertEquals("id uyuşmuyor", expectedProfilePhotoRow.get(0), actualRow.get(0));
                Assert.assertEquals("data uyuşmuyor", expectedProfilePhotoRow.get(1), actualRow.get(1));
                Assert.assertEquals("name uyuşmuyor", expectedProfilePhotoRow.get(2), actualRow.get(2));
                Assert.assertEquals("type uyuşmuyor", expectedProfilePhotoRow.get(3), actualRow.get(3));

            } else {
                Assert.fail("ResultSet boş geldi, id = 1 satırı bulunamadı.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Veri dogrulama sırasında hata oluştu.");
        }
    }
}
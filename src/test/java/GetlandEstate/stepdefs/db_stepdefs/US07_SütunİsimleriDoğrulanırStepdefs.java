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

    @Given("Veritabanı ile baglantı kurulur")
    public void Veritabanıilebaglantıkurulur() throws SQLException {

        connection = DriverManager.getConnection(ConfigReader.getProperty("dbUrl"),
                ConfigReader.getProperty("dbUsername"), ConfigReader.getProperty("dbPassword"));
    }

    @When("Countries sütun tablosu çağrılır")
    public void countriesSütunTablosuÇağrılır() {

        expectedTableNames = Arrays.asList(
                "id", "lat", "Ing", "name"
        );
    }

    @And("Countries sütundaki veriler eksiksiz gelmeli")
    public void countriesSütundakiVerilerEksiksizGelmeli() throws SQLException {
        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM countries LIMIT 1"); // 1 satır al

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        actualTableNames = new ArrayList<>();

        // Veritabanındaki sütun isimlerini al
        for (int i = 1; i <= columnCount; i++) {
            actualTableNames.add(metaData.getColumnName(i));
        }

        // Beklenen sütun isimlerini listeleyin
        expectedTableNames = Arrays.asList("id", "lat", "lng", "name");

        // Konsola yazdır (Hata tespiti için)
        System.out.println("Expected Columns: " + expectedTableNames);
        System.out.println("Actual Columns: " + actualTableNames);

        // Doğrulama yap
        Assert.assertTrue("Sütun isimleri uyuşmuyor!", actualTableNames.containsAll(expectedTableNames));
    }

            // TC_02------------------------------------




    @And("Countries tablosundan {int} , {int} id numaralı sütunlar çağrılır.")
    public void countriesTablosundanIdNumaralıSütunlarÇağrılır(int id1, int id2) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM countries WHERE id IN (?, ?)");
        pstmt.setInt(1, id1);
        pstmt.setInt(2, id2);
        resultSet = pstmt.executeQuery();

        boolean id1Exists = false;
        boolean id2Exists = false;

        while (resultSet.next()) {
            int currentId = resultSet.getInt("id");
            if (currentId == id1) id1Exists = true;
            if (currentId == id2) id2Exists = true;

            System.out.println("ID: " + currentId +
                    ", Lat: " + resultSet.getDouble("lat") +
                    ",Lng " + resultSet.getDouble("lng") +
                    ", Name: " + resultSet.getString("name"));

        }

        Assert.assertTrue(id1Exists);
        Assert.assertTrue(id2Exists);
    }
}



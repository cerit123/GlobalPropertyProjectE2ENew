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
                "id", "created_at", "email", "first_name", "last_name", "message", "status"
        );
    }

    @And("Contacts sütundaki veriler eksiksiz gelmeli")
    public void contactsSütundakiVerilerEksiksizGelmeli() throws SQLException {
        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM contacts LIMIT 1");

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        actualTableNames = new ArrayList<>();

        // Sütun isimlerini al
        for (int i = 1; i <= columnCount; i++) {
            actualTableNames.add(metaData.getColumnName(i));
        }

        // Beklenen sütun isimlerini listeleyin
        expectedTableNames = Arrays.asList(
                "id", "created_at", "email", "first_name", "last_name", "message", "status");

        // Konsola yazdır (Hata tespiti için)
        System.out.println("Expected Columns: " + expectedTableNames);
        System.out.println("Actual Columns: " + actualTableNames);

        // Doğrulama yap
        Assert.assertTrue("Sütun isimleri uyuşmuyor!", actualTableNames.containsAll(expectedTableNames));
    }

    // TC_02--------------------------------

    @And("Contacts tablosundan {int} , {int} id numaralı sütunlar çağrılır.")
    public void contactsTablosundanIdNumaralıSütunlarÇağrılır(int id1, int id2) throws SQLException {
        // Veritabanı sorgusu
        String query = "SELECT * FROM contacts WHERE id IN (?, ?)";

        // PreparedStatement ile sorgu hazırlanıyor
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id1);  // Birinci ID
            pstmt.setInt(2, id2);  // İkinci ID

            try (ResultSet resultSet = pstmt.executeQuery()) {
                boolean id1Exists = false;
                boolean id2Exists = false;

                // Sonuçları döngüyle işliyoruz
                while (resultSet.next()) {
                    int currentId = resultSet.getInt("id");

                    // ID1 ve ID2'yi kontrol ediyoruz
                    if (currentId == id1) id1Exists = true;
                    if (currentId == id2) id2Exists = true;

                    // Sütunların verilerini yazdırıyoruz
                    System.out.println("ID: " + currentId +
                            ", Created At: " + resultSet.getTimestamp("created_at") +
                            ", Email: " + resultSet.getString("email") +
                            ", First Name: " + resultSet.getString("first_name") +
                            ", Last Name: " + resultSet.getString("last_name") +
                            ", Message: " + resultSet.getString("message") +
                            ", Status: " + resultSet.getString("status"));
                }

                // Assert ile ID'lerin varlığını kontrol ediyoruz
                Assert.assertTrue("ID1 verisi bulunamadı!", id1Exists);
                Assert.assertTrue("ID2 verisi bulunamadı!", id2Exists);
            }
        } catch (SQLException e) {
            // Veritabanı hata durumunda loglama
            e.printStackTrace();
            throw e; // Hata tekrar fırlatılıyor
        }
                }
            }











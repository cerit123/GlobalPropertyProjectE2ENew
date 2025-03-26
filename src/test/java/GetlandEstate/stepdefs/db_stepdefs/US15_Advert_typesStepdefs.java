package GetlandEstate.stepdefs.db_stepdefs;

import GetlandEstate.utilities.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US15_Advert_typesStepdefs {

    public static Connection connection;
    ResultSet resultSet;
    List<String> expectedTableNames;
    List<String> actualTableNames;
    Statement statement;
    private Object id1;
    private Object id2;

    @Given("Veritabanına bağlanılır.")
    public void veritabanınaBağlanılır() throws SQLException {

        connection = DriverManager.getConnection(ConfigReader.getProperty("dbUrl"),
               ConfigReader.getProperty("dbUsername"), ConfigReader.getProperty("dbPassword"));
    }

    @When("advert_types sutun tablosu çağrılır")
    public void advert_typesSutunTablosuÇağrılır() {

        expectedTableNames = Arrays.asList(
                "id", "built_in", "title"
        );
    }

    @And("advert_types sutun tablosundaki veriler eksiksiz gelmeli")
    public void advert_typesSutunTablosundakiVerilerEksiksizGelmeli() throws SQLException {

        Statement statement = connection.createStatement();
       resultSet = statement.executeQuery("SELECT * FROM advert_types LIMIT 1");

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        actualTableNames = new ArrayList<>();

        // Sütun isimlerini al
        for (int i = 1; i <= columnCount; i++) {
            actualTableNames.add(metaData.getColumnName(i));
        }

        // Beklenen sütun isimlerini listeleyin
        expectedTableNames = Arrays.asList(
                "id", "built_in", "title");

        // Konsola yazdır (Hata tespiti için)
        System.out.println("Expected Columns: " + expectedTableNames);
        System.out.println("Actual Columns: " + actualTableNames);

        // Doğrulama yap
        Assert.assertTrue("Sütun isimleri uyuşmuyor!", actualTableNames.containsAll(expectedTableNames));
    }

    @When("advert_types tablosunun id, built_in, title sütunları getirilir.")
    public void advert_typesTablosununIdBuilt_inTitleSütunlarıGetirilir() {
    }

    @And("advert_types tablosundan {int}, {int} id numaralı sütunlar çağrılır.")
    public void advert_typesTablosundanIdNumaralıSütunlarÇağrılır(int id1, int id2) throws SQLException {

        PreparedStatement pstmt = connection.prepareStatement("SELECT id, built_in, title FROM advert_types WHERE id IN (?, ?)");
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
                    ", Built_in: " + resultSet.getBoolean("built_in") +
                    ", Title: " + resultSet.getString("title"));
        }

        Assert.assertTrue("ID1 bulunamadı!", id1Exists);
        Assert.assertTrue("ID2 bulunamadı!", id2Exists);
    }


}






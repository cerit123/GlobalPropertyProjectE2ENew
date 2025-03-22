package GetlandEstate.stepdefs.api_stepdefs;

import GetlandEstate.stepdefs.db_stepdefs.US01_TabloİsimleriniDoğrulaStepdefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_06DBStepdefs {

    List<String> expectedColumnNames;//beklenen sutun isimlerini tutmak icin
    List<String> actualColumnNames; //veri tabanindan gelen gercek sutun isimlerini tutmak icin
    ResultSet resultSet;//SQL sorgusu sonucunu tutmak icin
    Statement statement;

    @When("Beklenen sutun isimleri duzenlenir")
    public void beklenenSutunIsimleriDuzenlenir() {

        expectedColumnNames = Arrays.asList("id", "lat", "lng", "name", "country_id");//beklenen sutun isimleri expectedCloumsa yuklenir
        System.out.println("expectedColumnNames = " + expectedColumnNames);
    }



    @And("Cities tablosu sutun isimleri icin query gonderilir")
//Sutun isimlerini almak icin query gonderilir sql sorgusu gonderiliyor
    public void citiesTablosuSutunIsimleriIcinQueryGonderilir() throws SQLException {

        statement = US01_TabloİsimleriniDoğrulaStepdefs.connection.createStatement();//veri tabanina baglaniyor
        resultSet = statement.executeQuery //cities tablosu sutun isimlerini almak icin veri  srgu goneriyor
                ("SELECT column_name \n" +
                        "FROM information_schema.columns \n" +
                        "WHERE table_name = 'cities';");
    }

    @Then("Cities sutun isimlerini dogrula")
    public void citiesSutunIsimleriniDogrula() throws SQLException {
        actualColumnNames = new ArrayList<>();

        while (resultSet.next()) {//tum sutunlari tek tek donguye aliyor
            actualColumnNames.add(resultSet.getString("column_name"));
        }

        //  Karşılaştırma (Eksik veya fazla sutun var mı?)
        List<String> missingColumns = new ArrayList<>(expectedColumnNames);
        missingColumns.removeAll(actualColumnNames); // Expected'de olup Actual'de olmayanlar

        List<String> extraColumns = new ArrayList<>(actualColumnNames);
        extraColumns.removeAll(expectedColumnNames); // Actual'de olup Expected'de olmayanlar

        //  Sonuçları yazdır(junit)
      Assert.assertTrue("Eksik sütunlar bulundu: " + missingColumns, missingColumns.isEmpty());
        Assert.assertTrue("Fazla sütunlar bulundu: " + extraColumns, extraColumns.isEmpty());


//        if (missingColumns.isEmpty() && extraColumns.isEmpty()) {
//            System.out.println("✅ All column names match expected data!");
//        } else {
//            if (!missingColumns.isEmpty()) {
//                System.out.println("❌ Missing columns: " + missingColumns);
//            }
//            if (!extraColumns.isEmpty()) {
//                System.out.println("❌ Extra columns found: " + extraColumns);
//            }
//        }
    }

    //TC-2----------
    @Then("Tabloda Adana isimli sehir icin query gonderilir")
    public void tablodaAdanaIsimliSehirIcinQueryGonderilir() throws SQLException {
        // Veritabanına bağlanarak Adana şehri için sorgu gönder
        Statement statement = US01_TabloİsimleriniDoğrulaStepdefs.connection.createStatement();


            // SQL sorgusunu çalıştır
            resultSet = statement.executeQuery("SELECT * FROM cities WHERE name = 'Adana'");

            if (resultSet.next()) {
                System.out.println("Adana şehri bulundu!");
            } else {
                System.out.println("Adana şehri bulunamadı!");
            }

    }

    @Then("Adana şehrinin bilgileri aşağıdaki değerlerle eşleşmelidir")
    public void adanaŞehrininBilgileriAşağıdakiDeğerlerleEşleşmelidir() throws SQLException {
        if (resultSet.next()) {
            // Beklenen değerler
            int expectedId = 4121;
            double expectedLat = 36.98635;
            double expectedLng = 35.32528;
            String expectedName = "Adana";
            int expectedCountryId = 223;

            // Veritabanından gelen değerleri al
            int actualId = resultSet.getInt("id");
            double actualLat = resultSet.getDouble("lat");
            double actualLng = resultSet.getDouble("lng");
            String actualName = resultSet.getString("name");
            int actualCountryId = resultSet.getInt("country_id");

            // Değerleri karşılaştır
            Assert.assertEquals(expectedId, actualId);
            Assert.assertEquals(expectedLat, actualLat, 0.00001);
            Assert.assertEquals(expectedLng, actualLng, 0.00001);
            Assert.assertEquals(expectedName, actualName);
            Assert.assertEquals(expectedCountryId, actualCountryId);

            System.out.println("Test başarıyla geçti: Veriler eşleşiyor!");
        } else {
            Assert.fail("Adana şehri bilgileri alınamadı!");
        }
    }




}

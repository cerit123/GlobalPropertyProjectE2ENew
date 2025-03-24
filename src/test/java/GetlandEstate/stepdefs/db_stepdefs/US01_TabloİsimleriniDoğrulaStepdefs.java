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

public class US01_TabloİsimleriniDoğrulaStepdefs {

    public static Connection connection;
    ResultSet resultSet;
    List<String> expectedTableNames;
    List<String> actualTableNames;

    @Given("Database bağlantısı sağlanır")
    public void databaseBağlantısıSağlanır() throws SQLException {

        connection = DriverManager.getConnection(ConfigReader.getProperty("dbUrl"),
                ConfigReader.getProperty("dbUsername"), ConfigReader.getProperty("dbPassword"));

    }

    @And("Beklenen tablo isimleri düzenlenir")
    public void beklenenTabloIsimleriDüzenlenir() {

        expectedTableNames = Arrays.asList(
                "category_property_keys", "confirmation_token", "daily_reports",
                "logs", "favorites", "images", "profile_photos",
                "category_property_values", "advert_types", "cities",
                "cmd_exec", "personel", "adverts", "countries",
                "districts", "users", "tour_requests", "categories", "contacts"
        );

    }

    @When("Tablo isimlerini almak için query gönderilir")
    public void tabloIsimleriniAlmakIçinQueryGönderilir() throws SQLException {

        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT tablename FROM pg_tables WHERE schemaname = 'public'");


    }

    @Then("Tablo isimleri dogrulanır")
    public void tabloIsimleriDogrulanır() throws SQLException {

        actualTableNames = new ArrayList<>();

        while (resultSet.next()) {
            actualTableNames.add(resultSet.getString("tablename"));
        }


        //  Karşılaştırma (Eksik veya fazla tablo var mı?)
        List<String> missingTables = new ArrayList<>(expectedTableNames);
        missingTables.removeAll(actualTableNames); // Expected'de olup Actual'de olmayanlar

        List<String> extraTables = new ArrayList<>(actualTableNames);
        extraTables.removeAll(expectedTableNames); // Actual'de olup Expected'de olmayanlar

        //  Sonuçları yazdır
        if (missingTables.isEmpty() && extraTables.isEmpty()) {
            System.out.println("✅ All table names match expected data!");
        } else {
            if (!missingTables.isEmpty()) {
                System.out.println("❌ Missing tables: " + missingTables);
            }
            if (!extraTables.isEmpty()) {
                System.out.println("❌ Extra tables found: " + extraTables);
            }
        }

    }
}

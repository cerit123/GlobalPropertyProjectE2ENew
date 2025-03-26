package GetlandEstate.stepdefs.db_stepdefs;

import GetlandEstate.pojos.US11_DB_logsPojo;
import GetlandEstate.pojos.US14_DB_tour_requestsPojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class US11_logsStepdefs {


    US11_DB_logsPojo expectedData;
    List<String> expectedColumnNames1;
    List<Integer> id;
    List<Integer> advert_id;
    List<String> created_at;
    List<String> actualColumnNames1;
    ResultSet resultSet1;

    @And("Beklenen logs tablosu sütun isimleri düzenlenir")
    public void beklenenLogsTablosuSütunIsimleriDüzenlenir() {

        expectedColumnNames1 = Arrays.asList(
                "id", "created_at", "message",
                "advert_id",
                "user_id"
        );
    }

    @When("logs tablosu sütun isimlerini almak için query gönderilir")
    public void logsTablosuSütunIsimleriniAlmakIçinQueryGönderilir() throws SQLException {

        Statement statement = US01_TabloİsimleriniDoğrulaStepdefs.connection.createStatement();
        resultSet1 = statement.executeQuery("SELECT column_name \n" +
                "FROM information_schema.columns \n" +
                "WHERE table_name = 'logs'");


    }

    @Then("logs tablosu sütun isimleri dogrulanır")
    public void logsTablosuSütunIsimleriDogrulanır() throws SQLException {

        actualColumnNames1 = new ArrayList<>();

        while (resultSet1.next()) {
            actualColumnNames1.add(resultSet1.getString("column_name"));
        }


        //  Karşılaştırma (Eksik veya fazla tablo var mı?)
        List<String> eksikTables = new ArrayList<>(expectedColumnNames1);
        eksikTables.removeAll(actualColumnNames1); // Expected'de olup Actual'de olmayanlar

        List<String> fazlaTables = new ArrayList<>(actualColumnNames1);
        fazlaTables.removeAll(expectedColumnNames1); // Actual'de olup Expected'de olmayanlar

        //  Sonuçları yazdır
        if (eksikTables.isEmpty() && fazlaTables.isEmpty()) {
            System.out.println("✅ All column names match expected data!");
        } else {
            if (!eksikTables.isEmpty()) {
                System.out.println("❌ Missing columns: " + eksikTables);
            }
            if (!fazlaTables.isEmpty()) {
                System.out.println("❌ Extra columns found: " + fazlaTables);
            }
        }
    }

    @And("Beklenen logs dataları düzenlenir")
    public void beklenenLogsDatalarıDüzenlenir() {

         expectedData = new US11_DB_logsPojo(3417,"Mar 15, 2025, 5:26:44 PM","Advert updated by :admin@gmail.com", 409, 1);


        //3417	Mar 15, 2025, 5:26:44 PM	Advert updated by :admin@gmail.com	409	1

    }

    @When("logs dataları için query gönderilir")
    public void logsDatalarıIçinQueryGönderilir() throws SQLException {
        Statement statement = US01_TabloİsimleriniDoğrulaStepdefs.connection.createStatement();
        resultSet1 = statement.executeQuery("SELECT * FROM logs WHERE id = 3417");
    }

    @Then("logs datası beklenen data ile karşılaştırılır")
    public void logsDatasıBeklenenDataIleKarşılaştırılır() throws SQLException {

        resultSet1.next();
        System.out.println(resultSet1.getString("created_at"));

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        LocalDateTime created_atFormat = LocalDateTime.parse(resultSet1.getString("created_at"), inputFormatter);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy, h:mm:ss a", Locale.ENGLISH);
        String created_at = created_atFormat.format(outputFormatter);

        Assert.assertEquals(expectedData.id,resultSet1.getInt("id"));
        Assert.assertEquals(expectedData.created_at,created_at);
        Assert.assertEquals(expectedData.message,resultSet1.getString("message"));
        Assert.assertEquals(expectedData.advert_id,resultSet1.getInt("advert_id"));
        Assert.assertEquals(expectedData.user_id,resultSet1.getInt("user_id"));


    }
}

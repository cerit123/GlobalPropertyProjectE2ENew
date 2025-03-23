package GetlandEstate.stepdefs.db_stepdefs;

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

public class US14_SütunIsimleriVeBilgileriStepdefs {


    ResultSet resultSet;
    List<String> expectedColumnNames;
    List<String> actualColumnNames;
    US14_DB_tour_requestsPojo expectedData;
    ResultSet resultSet1;


    @And("Beklenen tour_requests tablosu sütun isimleri düzenlenir")
    public void beklenenTour_requestsTablosuSütunIsimleriDüzenlenir() {

        expectedColumnNames = Arrays.asList(
                "id", "created_at", "updated_at",
                "status", "tour_date", "tour_time", "advert_id",
                "guest_user_id", "owner_user_id"
        );


    }

    @When("tour_requests tablosu sütun isimlerini almak için query gönderilir")
    public void tour_requestsTablosuSütunIsimleriniAlmakIçinQueryGönderilir() throws SQLException {

        Statement statement = US01_TabloİsimleriniDoğrulaStepdefs.connection.createStatement();
        resultSet = statement.executeQuery("SELECT column_name \n" +
                "FROM information_schema.columns \n" +
                "WHERE table_name = 'tour_requests'");


    }

    @Then("tour_requests tablosu sütun isimleri dogrulanır")
    public void tour_requestsTablosuSütunIsimleriDogrulanır() throws SQLException {


        actualColumnNames = new ArrayList<>();

        while (resultSet.next()) {
            actualColumnNames.add(resultSet.getString("column_name"));
        }


        //  Karşılaştırma (Eksik veya fazla tablo var mı?)
        List<String> missingTables = new ArrayList<>(expectedColumnNames);
        missingTables.removeAll(actualColumnNames); // Expected'de olup Actual'de olmayanlar

        List<String> extraTables = new ArrayList<>(actualColumnNames);
        extraTables.removeAll(expectedColumnNames); // Actual'de olup Expected'de olmayanlar

        //  Sonuçları yazdır
        if (missingTables.isEmpty() && extraTables.isEmpty()) {
            System.out.println("✅ All column names match expected data!");
        } else {
            if (!missingTables.isEmpty()) {
                System.out.println("❌ Missing columns: " + missingTables);
            }
            if (!extraTables.isEmpty()) {
                System.out.println("❌ Extra columns found: " + extraTables);
            }
        }


    }

    @And("Beklenen tour_requests dataları düzenlenir")
    public void beklenenTour_requestsDatalarıDüzenlenir() {

       expectedData = new US14_DB_tour_requestsPojo(1,"Aug 6, 2024, 7:13:23PM","Aug 9, 2024, 12:00:01AM",2,"Aug 8, 2024, 12:00:00AM","Jan 1, 1970, 6:00:00AM",37,39,8);


    }

    @When("tour_requests dataları için query gönderilir")
    public void tour_requestsDatalarıIçinQueryGönderilir() throws SQLException {

        Statement statement = US01_TabloİsimleriniDoğrulaStepdefs.connection.createStatement();
         resultSet1 = statement.executeQuery("SELECT * FROM tour_requests WHERE id = 1");

    }

    @Then("tour_requests datası beklenen data ile karşılaştırılır")
    public void tour_requestsDatasıBeklenenDataIleKarşılaştırılır() throws SQLException {

        resultSet1.next();
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        LocalDateTime created_atFormat = LocalDateTime.parse(resultSet1.getString("created_at"), inputFormatter);
        LocalDateTime updated_atFormat = LocalDateTime.parse(resultSet1.getString("updated_at"), inputFormatter);
        LocalDateTime tour_dateFormat = LocalDateTime.parse(resultSet1.getString("tour_date"), inputFormatter);
        LocalDateTime tour_timeFormat = LocalDateTime.parse(resultSet1.getString("tour_time"), inputFormatter);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy, h:mm:ssa");
        String created_at = created_atFormat.format(outputFormatter);
        String updated_at = updated_atFormat.format(outputFormatter);
        String tour_date = tour_dateFormat.format(outputFormatter);
        String tour_time = tour_timeFormat.format(outputFormatter);



        Assert.assertEquals(expectedData.id,resultSet1.getInt("id"));
        Assert.assertEquals(expectedData.created_at,created_at);
        Assert.assertEquals(expectedData.updated_at,updated_at);
        Assert.assertEquals(expectedData.status,resultSet1.getInt("status"));
        Assert.assertEquals(expectedData.tour_date,tour_date);
        Assert.assertEquals(expectedData.tour_time,tour_time);
        Assert.assertEquals(expectedData.advert_id,resultSet1.getInt("advert_id"));
        Assert.assertEquals(expectedData.guest_user_id,resultSet1.getInt("guest_user_id"));
        Assert.assertEquals(expectedData.owner_user_id,resultSet1.getInt("owner_user_id"));



    }
}

package GetlandEstate.stepdefs.db_stepdefs;

import GetlandEstate.utilities.ConfigReader;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US02Stepdefs {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    @Given("veritabanına bağlanılır")
    public void veritabanınaBağlanılır() throws SQLException {
        connection = DriverManager.getConnection(ConfigReader.getProperty("dbUrl"),
                ConfigReader.getProperty("dbUsername"),ConfigReader.getProperty("dbPassword"));
        statement= connection.createStatement();
    }
    @When("Categories tablosunun kontrol edilir")
    public void categoriesTablosununKontrolEdilir() throws SQLException {
        String sqlquery="select * from categories";
        resultSet=statement.executeQuery(sqlquery);
    }
    @Then("aşağıdaki {string} bulunmalıdır:")
    public void aşağıdakiBulunmalıdır(String sütunIsimleri) throws SQLException {
        List<String> actualColumns = new ArrayList<>();
        while (resultSet.next()) {
            actualColumns.add(resultSet.getString("COLUMN_NAME"));
            System.out.println("resultSet.getString(\"COLUMN_NAME\") = " + resultSet.getString("COLUMN_NAME"));
        }



    }

    @When("categories tablosunun id, title, is_active, ve slug sütunları getirilir")
    public void categoriesTablosununIdTitleIs_activeVeSlugSütunlarıGetirilir() {
    }

    @And("id sütünunu uniq, is active sütununun sadece true ve false, slıg sütununun ise title sütunundaki verileri barındırdığı görülür")
    public void idSütünunuUniqIsActiveSütunununSadeceTrueVeFalseSlıgSütunununIseTitleSütunundakiVerileriBarındırdığıGörülür() {
    }

    @Then("Database bağlantısı kapatılır")
    public void databaseBağlantısıKapatılır() {
    }


}

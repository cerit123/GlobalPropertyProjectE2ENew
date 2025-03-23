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


public class US02_CategoriesTableStepdefs {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    List<String> expectedTableNames;
    List<String> actualTableNames;
    List<Integer> id;
    List<String> title;
    List<Boolean> is_active;
    List<String> slug;
    @Given("veritabanına bağlanılır")
    public void veritabanınaBağlanılır() throws SQLException {
        connection = DriverManager.getConnection(ConfigReader.getProperty("dbUrl"),
                ConfigReader.getProperty("dbUsername"),ConfigReader.getProperty("dbPassword"));
        statement= connection.createStatement();
    }
    @When("Categories tablosunun kontrol edilir")
    public void categoriesTablosununKontrolEdilir() throws SQLException {
        String sqlquery="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'categories'";
        resultSet=statement.executeQuery(sqlquery);
    }
    @Then("tablonun sütun isimlerinin expected result ile uyuştuğu görülür")
    public void tablonunSütunIsimlerininExpectedResultIleUyuştuğuGörülür() throws SQLException {
        expectedTableNames = Arrays.asList("id", "created_at" , "updated_at" , "is_active", "built_in" ,"seq", "title", "slug" , "icon"  );
        actualTableNames = new ArrayList<>();
        while (resultSet.next()) {

            actualTableNames.add(resultSet.getString("COLUMN_NAME"));
        }

        System.out.println("expectedTableNames = " + expectedTableNames);
        System.out.println("actualTableNames = " + actualTableNames);
        for (int i = 0; i < expectedTableNames.size(); i++) {
            Assert.assertEquals(expectedTableNames.get(i), actualTableNames.get(i));
        }
    }

    @When("categories tablosunun id, title, is_active, ve slug sütunları getirilir")
    public void categoriesTablosununIdTitleIs_activeVeSlugSütunlarıGetirilir() throws SQLException {
        String query="SELECT id, title, is_active, slug FROM categories";
        resultSet=statement.executeQuery(query);

        id       =new ArrayList<>();
        title     =new ArrayList<>();
        is_active=new ArrayList<>();
        slug      =new ArrayList<>();

        while (resultSet.next()){
            id.add(resultSet.getInt("id"));
            title.add(resultSet.getString("title"));
            is_active.add(resultSet.getBoolean("is_active"));
            slug.add(resultSet.getString("slug"));
        }


    }

    @And("id sütünunu uniq, is active sütununun sadece true ve false, slıg sütununun ise title sütunundaki verileri barındırdığı görülür")
    public void idSütünunuUniqIsActiveSütunununSadeceTrueVeFalseSlıgSütunununIseTitleSütunundakiVerileriBarındırdığıGörülür() {

        List<String> errors = new ArrayList<>();
       for (int i = 0; i < id.size()-1; i++){


           try {
               Assert.assertNotEquals(id.get(i), id.get(i + 1));
           } catch (AssertionError e) {
               errors.add(e.getMessage());
           }

           try {
               Assert.assertTrue(is_active.get(i).toString().contains("true")||is_active.get(i).toString().contains("false"));
           } catch (AssertionError e) {
               errors.add(e.getMessage());
           }

           String slugValue = slug.get(i);
           String titleValue = title.get(i).toLowerCase();

           // Slug içindeki kelimelerin title içinde olup olmadığını kontrol et
           boolean containsAll = slugValue.replaceAll("-"," ").contains(titleValue.toLowerCase());


           try {
               Assert.assertTrue( slugValue + " does not contain all words in " + titleValue,containsAll);
           } catch (AssertionError e) {
               errors.add(e.getMessage());
           }




       }
       if (errors.size()!=0){
           System.out.println("errors = " + errors);
       }else {
           System.out.println("Test passed");
       }

    }

    @Then("Database bağlantısı kapatılır")
    public void databaseBağlantısıKapatılır() throws SQLException {
        connection.close();
        statement.close();
        resultSet.close();
    }



}

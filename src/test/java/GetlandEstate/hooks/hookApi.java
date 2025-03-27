package GetlandEstate.hooks;


import GetlandEstate.base_url.BaseUrl;
import GetlandEstate.pages.HomePage;
import GetlandEstate.pages.LoginPage;
import GetlandEstate.utilities.ConfigReader;
import GetlandEstate.utilities.Driver;
import GetlandEstate.utilities.WaitUtils;
import io.cucumber.java.Before;

import static GetlandEstate.base_url.BaseUrl.setUp;
import static GetlandEstate.base_url.BaseUrl.setUpNoAuth;

public class hookApi {

    @Before("@ApiCustomer")
    public void apiCustomer() {
        try {
            setUp(ConfigReader.getProperty("emailCustomer"), ConfigReader.getProperty("passwordCustomer"));
        } catch (Exception e) {
            System.err.println("API Customer setup failed: " + e.getMessage());
            e.printStackTrace();
        }

    }
    @Before("@apiAdmin")
    public void apiAdmin() {
        try {
            setUp(ConfigReader.getProperty("emailAdmin"), ConfigReader.getProperty("passwordAdmin"));
        } catch (Exception e) {
            System.err.println("API Admin setup failed: " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Before("@apiManager")
    public void apiManager() {
        try {
            setUp(ConfigReader.getProperty("emailManager"), ConfigReader.getProperty("passwordManager"));
        } catch (Exception e) {
            System.err.println("API Manager setup failed: " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Before("@NoAuth")
    public void NoAuth() {
        try {
            setUpNoAuth();
        } catch (Exception e) {
            System.err.println("API Manager setup failed: " + e.getMessage());
            e.printStackTrace();
        }

    }

}

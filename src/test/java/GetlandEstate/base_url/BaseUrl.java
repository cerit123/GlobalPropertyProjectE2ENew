package GetlandEstate.base_url;

import GetlandEstate.utilities.Authentication;
import GetlandEstate.utilities.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseUrl {
    public static RequestSpecification spec;

    public static void setUp(String email, String password) throws Exception {
        spec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("baseUrl"))
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer "+ Authentication.generateToken(email,password))
                .build();
    }

    public static RequestSpecification specNoAuth;

    public static void setUpNoAuth() throws Exception {
        specNoAuth = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("baseUrl"))
                .setContentType(ContentType.JSON)
                .build();
    }
}

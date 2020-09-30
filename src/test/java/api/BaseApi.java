package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseApi {

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://develop.alb.cu-bx.com/device/";
    }
}

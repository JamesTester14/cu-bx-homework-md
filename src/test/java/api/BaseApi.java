package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;


public class BaseApi {

    @BeforeEach
    public void setup(){
        RestAssured.baseURI = "https://develop.alb.cu-bx.com/";
    }
}

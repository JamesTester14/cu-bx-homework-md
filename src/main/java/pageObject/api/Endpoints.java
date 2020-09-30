package pageObject.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import pageObject.api.basedevicesResponse.BaseDevices;
import pageObject.api.deviceinfoRequest.DeviceInfo;

import java.io.IOException;
import java.util.*;

import static io.restassured.RestAssured.given;
import static pageObject.api.SpecificationHandler.requestSpec;

public class Endpoints {

    @Step
    public String getToken(){
        Map<String, Object> map = new HashMap<>();
        map.put("email", "diwad95334@brosj.net");
        map.put("password", "GQJWPwynKED33A73");
        return given().spec(requestSpec)
                .header("Content-Type", "application/json")
                .body(map)
                .when()
                .post("ums/v1/users/loginCredentials").then().log().body()
                .extract().body().as(AuthResponse.class).getAccessToken();
    }

    @Step
    public List<BaseDevices> getBaseDevices(){
        return new ArrayList<>(Arrays.asList(given().spec(requestSpec)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+ getToken())
                .when()
                .get("device/api/basedevices")
                .then()
                .extract().body().as(BaseDevices[].class)));
    }

    @Step
    public void putDeviceInfo(String id, DeviceInfo device) throws IOException {
        ObjectMapper obj = new ObjectMapper();
        ValidatableResponse response = given().spec(requestSpec)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+ getToken())
                .body(obj.writeValueAsString(device))
                .put("device/v1/wrapper/host/"+id)
                .then().log().body().statusCode(200);
    }
}

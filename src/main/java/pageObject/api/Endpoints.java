package pageObject.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import pageObject.api.basedevices.response.BaseDevices;
import pageObject.api.deviceinfo.request.DeviceInfo;

import static io.restassured.RestAssured.given;
import static pageObject.api.SpecificationHandler.requestSpec;

public class Endpoints {

    @Step
    public BaseDevices getBaseDevices(){
        return given().spec(requestSpec)
                .when()
                .get("/api/basedevices")
                .then()
                .extract().body().as(BaseDevices.class);
    }

    @Step
    public Response postDeviceInfo(String id){
        DeviceInfo deviceInfo = new DeviceInfo().toBuilder().build();
        return given().spec(requestSpec)
                .when()
                .body(deviceInfo)
                .post("/deviceinfo/"+id);
//                .then()
//                .extract().body().as();
    }
}

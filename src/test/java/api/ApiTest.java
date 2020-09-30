package api;

import org.junit.jupiter.api.Test;
import pageObject.api.Endpoints;

public class ApiTest extends BaseApi{
    Endpoints endpoints = new Endpoints();

    @Test
    void checkInformationIsUpdated(){
        endpoints.postDeviceInfo("123");
        endpoints.getBaseDevices();
    }
}

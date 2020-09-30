package api;

import junitTags.Api;
import org.junit.jupiter.api.Test;
import pageObject.api.Endpoints;
import pageObject.api.basedevicesResponse.BaseDevices;
import pageObject.api.deviceinfoRequest.DeviceInfo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Api
public class ApiTest extends BaseApi {
    Endpoints endpoints = new Endpoints();

    @Test
    void checkInformationIsUpdated() throws IOException {
        updateDeviceInfo();
        String name = null;
        List<BaseDevices> baseDevices = endpoints.getBaseDevices();
        Optional<BaseDevices> expectedBaseDevice = baseDevices.stream().filter(baseDevices1 -> baseDevices1.getManufacturerId()
                .equals("13a3dd38-fd5b-46c0-a158-c46ffde1e4ef")).findFirst();
        if (expectedBaseDevice.isPresent()){
            name = expectedBaseDevice.get().getName();
        }
        name.equals("Edited Name");
    }

    @Test
    void updateDeviceInfo() throws IOException {
        DeviceInfo device = new DeviceInfo().toBuilder()
                .manufacturerId("13a3dd38-fd5b-46c0-a158-c46ffde1e4ef")
                .name("Edited Name TEST")
                .fwVersion("1.1")
                .hwVersion("1.2")
                .reportedStatus("1")
                .timezone("test")
                .locationType("location")
                .type(0)
                .locationId("7813e288-1618-4f78-816d-436822cadd7b")
                .build();

        endpoints.putDeviceInfo("13a3dd38-fd5b-46c0-a158-c46ffde1e4ef", device);

    }
}

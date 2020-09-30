package pageObject.api.basedevicesResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseDevices {

    private String manufacturerId;
    private String name;
//    private ArrayList<Datum> datum;
}

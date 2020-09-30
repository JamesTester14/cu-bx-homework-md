package pageObject.api.deviceinfoRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class DeviceInfo {
    private String manufacturerId;
    private String fwVersion;
    private String hwVersion;
    private String name;
    private String reportedStatus;
    private String timezone;
    private String locationType;
    private int type;
    private String locationId;

}

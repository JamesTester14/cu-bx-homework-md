package pageObject.api.deviceinfo.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class DeviceInfo {
    public String appVersion;
    public Configuration configuration;
    public String fwVersion;
    public String hwVersion;
    public String manufacturerId;
    public String serialNumber;
}

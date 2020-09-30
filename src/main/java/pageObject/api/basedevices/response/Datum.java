package pageObject.api.basedevices.response;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Datum {
    public String activeStatus;
    public String appVersion;
    public List<String> childrenIds;
    public Date creationTime;
    public Date deviceLastModified;
    public String deviceLastModifiedByUserId;
    public String fwVersion;
    public String hwVersion;
    public int isOnlineTimestamp;
    public Date lastModifiedTime;
    public String lastOnlineIpAddress;
    public String locationId;
    public String manufacturerId;
    public String name;
    public boolean online;
    public String ownerId;
    public String reportedStatus;
    public String serialNumber;
    public String sessionIdentifier;
    public int status;
    public String tenantId;
    public String timeZone;
    public int type;
}

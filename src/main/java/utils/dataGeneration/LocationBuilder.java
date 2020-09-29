package utils.dataGeneration;

import lombok.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class LocationBuilder {
    String name;
    String address;
    String country;
    String city;
}

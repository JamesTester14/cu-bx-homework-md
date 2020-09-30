package utils.dataGeneration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserBuilder {
    String fname;
    String lname;
    String email;
    String phone;
    String company;
    String height;
    String weight;
    String gender;
    String age;

}

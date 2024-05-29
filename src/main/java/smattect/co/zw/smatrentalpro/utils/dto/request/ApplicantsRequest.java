package smattect.co.zw.smatrentalpro.utils.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantsRequest {

    private  long propertyId;
    private String firstname;
    private String lastname;
    private String dob;
    private String ssn;
    private String idNumber;
    private String phone;
    private String occupation;
}

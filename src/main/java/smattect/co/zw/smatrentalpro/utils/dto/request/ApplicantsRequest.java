package smattect.co.zw.smatrentalpro.utils.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantsRequest {

    private  long propertyId;
    @NotEmpty
    private String firstname;
    @NotEmpty
    private String lastname;
    @NotEmpty
    private String dob;
    @NotEmpty
    private String ssn;
    @NotEmpty
    private String idNumber;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String occupation;
}

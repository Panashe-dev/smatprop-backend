package smattect.co.zw.smatrentalpro.utils.dto.request;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationRequest implements Serializable {
    @NotEmpty
    private String email;
    @NotEmpty
    private String usernames;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String passwords;
    @NotEmpty
    private String confirmPassword;
}

package smattect.co.zw.smatrentalpro.utils.dto.request;

import lombok.Data;

@Data
public class UpdateUserPasswordRequest {
    private long userId;
    private String username;
    private String password;
}

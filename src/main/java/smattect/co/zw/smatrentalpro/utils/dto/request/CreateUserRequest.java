package smattect.co.zw.smatrentalpro.utils.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
  private long userId;
  private String activationLink;
  private String email;
}

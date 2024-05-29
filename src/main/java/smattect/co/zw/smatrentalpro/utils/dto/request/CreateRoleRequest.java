package smattect.co.zw.smatrentalpro.utils.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoleRequest {
  private String roleName;
  private String roleDescription;
}

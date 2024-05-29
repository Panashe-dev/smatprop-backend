package smattect.co.zw.smatrentalpro.service;






import smattect.co.zw.smatrentalpro.utils.dao.Role;
import smattect.co.zw.smatrentalpro.utils.dto.request.CreateRoleRequest;

import java.util.List;


public interface RoleService {
  Long createRole(CreateRoleRequest createRoleRequest);

  List<Role> getAllRoles();
  Role findByRoleId(long id);

  void  deleteRole(long id);
}

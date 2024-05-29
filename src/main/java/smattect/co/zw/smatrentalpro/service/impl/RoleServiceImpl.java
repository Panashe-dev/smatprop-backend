package smattect.co.zw.smatrentalpro.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import smattect.co.zw.smatrentalpro.repository.RoleRepository;
import smattect.co.zw.smatrentalpro.service.RoleService;
import smattect.co.zw.smatrentalpro.utils.dao.Role;
import smattect.co.zw.smatrentalpro.utils.dto.request.CreateRoleRequest;
import smattect.co.zw.smatrentalpro.utils.exception.BusinessValidationException;

import java.text.MessageFormat;
import java.util.List;


@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

private  final RoleRepository roleRepository;

  @Override
  public Long createRole(CreateRoleRequest createRoleRequest) {

    if (roleRepository.findByRoleName(createRoleRequest.getRoleName()).isPresent()){
      throw   new BusinessValidationException(
              MessageFormat.format("Role {0} already exist", createRoleRequest.getRoleName()));
    }

    Role role = Role.builder()
        .roleName(createRoleRequest.getRoleName())
        .roleDescription(createRoleRequest.getRoleDescription())
        .build();
    Role savedRole = roleRepository.save(role);
    return savedRole.getId();
  }

  @Override
  public List<Role> getAllRoles() {
    return roleRepository.findAll();
  }

  @Override
  public Role findByRoleId(long id) {
    return roleRepository.findById(id).orElseThrow(()->new  BusinessValidationException(
            MessageFormat.format("Role with id {0} does not exist", id)));

  }

  @Override
  public void deleteRole(long id) {
    findByRoleId(id);
   roleRepository.deleteById(id);
  }
}

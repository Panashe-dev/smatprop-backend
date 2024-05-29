package smattect.co.zw.smatrentalpro.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smattect.co.zw.smatrentalpro.service.RoleService;
import smattect.co.zw.smatrentalpro.utils.dao.Role;
import smattect.co.zw.smatrentalpro.utils.dto.request.CreateRoleRequest;
import smattect.co.zw.smatrentalpro.utils.dto.response.ResponseMessage;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1",
        produces = MediaType.APPLICATION_JSON_VALUE,
        headers = "Accept=application/json")
@Tag(name = "Role Controller", description = "Role Controller")
@RequiredArgsConstructor
public class RoleController {

    private  final RoleService roleService;

    @PostMapping("/role")
    public ResponseEntity<ResponseMessage> createRole(@RequestBody @Valid CreateRoleRequest createRoleRequest) {
        roleService.createRole(createRoleRequest);
        return ResponseEntity.ok(new ResponseMessage("success"));
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> allRoles = roleService.getAllRoles();
        return ResponseEntity.ok(allRoles);
    }


}

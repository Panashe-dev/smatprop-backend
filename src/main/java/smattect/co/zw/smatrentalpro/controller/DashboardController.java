package smattect.co.zw.smatrentalpro.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smattect.co.zw.smatrentalpro.service.DashboardService;
import smattect.co.zw.smatrentalpro.utils.dto.response.DashboardResponse;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/dashboard")
@Tag(name = "Dashboard Controller", description = "Dashboard Controller")
@RequiredArgsConstructor
public class DashboardController {

    private  final DashboardService dashboardService;

    @GetMapping("/all")
    public ResponseEntity<DashboardResponse> getDashboardData(){
        return ResponseEntity.ok(dashboardService.getDashboardData());
    }



}

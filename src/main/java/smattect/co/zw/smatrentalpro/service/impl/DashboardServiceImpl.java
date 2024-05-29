package smattect.co.zw.smatrentalpro.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import smattect.co.zw.smatrentalpro.repository.ApplicantsRepository;
import smattect.co.zw.smatrentalpro.repository.PropertyRepository;
import smattect.co.zw.smatrentalpro.repository.UserRepository;
import smattect.co.zw.smatrentalpro.service.DashboardService;
import smattect.co.zw.smatrentalpro.utils.dto.response.DashboardResponse;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final UserRepository userRepository;
    private final PropertyRepository propertyRepository;
    private final ApplicantsRepository applicantsRepository;
    @Override
    public DashboardResponse getDashboardData() {
        DashboardResponse dashboardResponse=new DashboardResponse();
        dashboardResponse.setTotalUsers(String.valueOf(userRepository.count()));
        dashboardResponse.setTotalProperties(String.valueOf(propertyRepository.count()));
        dashboardResponse.setTotalApplicants(String.valueOf(applicantsRepository.count()));
        dashboardResponse.setTotalRegistration(String.valueOf(userRepository.count()));
        return dashboardResponse;
    }
}

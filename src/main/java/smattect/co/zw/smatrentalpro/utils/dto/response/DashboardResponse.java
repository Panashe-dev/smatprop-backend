package smattect.co.zw.smatrentalpro.utils.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardResponse {
    private String totalApplicants;
    private String totalProperties;
    private String totalUsers;
    private  String totalRegistration;
}

package smattect.co.zw.smatrentalpro.utils.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacilitiesResponse {
    private int bedrooms;

    private  int parking;

    private  int bathrooms;
}

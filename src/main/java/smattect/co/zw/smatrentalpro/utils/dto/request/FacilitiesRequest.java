package smattect.co.zw.smatrentalpro.utils.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacilitiesRequest {
    private int bedrooms;

    private  int parking;

    private  int bathrooms;
}

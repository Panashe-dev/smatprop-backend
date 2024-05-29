package smattect.co.zw.smatrentalpro.utils.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyRequest {

    private String  title;

    private String description;

    private Double price;

    private String country;

    private String city;

    private String address;

    private String image;

    private String currency;

    private  String propertyType;

    private  FacilitiesRequest facilitiesRequest;
}

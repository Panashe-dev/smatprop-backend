package smattect.co.zw.smatrentalpro.utils.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyResponse {

    private long id;

    private String  title;

    private String description;

    private Double price;

    private String currency;

    private String country;

    private String city;

    private String address;

    private String image;

    private  String propertyType;

    private  String reference;

    private FacilitiesResponse facilitiesResponse;
}

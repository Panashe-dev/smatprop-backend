package smattect.co.zw.smatrentalpro.utils.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePropertyRequest {

    private long id;

    private String  title;

    private String description;

    private Double price;

    private String currency;

    private String country;

    private String city;

    private String address;

    private  String propertyType;

    private String image;
}

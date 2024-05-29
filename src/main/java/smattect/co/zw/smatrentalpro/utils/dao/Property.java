package smattect.co.zw.smatrentalpro.utils.dao;


import jakarta.persistence.*;
import lombok.*;
import smattect.co.zw.smatrentalpro.utils.audit.DateAudit;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Property")
@Builder
public class Property  extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  title;

    private String description;

    private Double price;

    private String currency;

    private String country;

    private String city;

    private String address;

    private String image;

    private  String propertyType;

    private String reference;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Facilities facilities;

}

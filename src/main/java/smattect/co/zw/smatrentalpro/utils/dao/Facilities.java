package smattect.co.zw.smatrentalpro.utils.dao;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Facilities")
@Builder
public class Facilities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int bedrooms;

    private  int parking;

    private  int bathrooms;

}

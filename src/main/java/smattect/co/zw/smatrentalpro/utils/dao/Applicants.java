package smattect.co.zw.smatrentalpro.utils.dao;

import jakarta.persistence.*;
import lombok.*;
import smattect.co.zw.smatrentalpro.utils.audit.DateAudit;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Applicants")
@Builder
public class Applicants  extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String dob;
    private String ssn;
    private String idNumber;
    private String phone;
    private String occupation;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Property property;

}

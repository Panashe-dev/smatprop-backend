package smattect.co.zw.smatrentalpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smattect.co.zw.smatrentalpro.utils.dao.Applicants;

public interface ApplicantsRepository
        extends JpaRepository<Applicants,Long> {
}

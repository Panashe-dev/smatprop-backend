package smattect.co.zw.smatrentalpro.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smattect.co.zw.smatrentalpro.utils.dao.VerificationToken;

@Repository
public interface VerificationTokenRepository extends
        JpaRepository<VerificationToken,Long> {
    VerificationToken findByToken(String token);
}

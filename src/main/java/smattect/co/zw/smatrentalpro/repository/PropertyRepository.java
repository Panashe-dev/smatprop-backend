package smattect.co.zw.smatrentalpro.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smattect.co.zw.smatrentalpro.utils.dao.Property;

@Repository
@Transactional
public interface PropertyRepository
        extends JpaRepository<Property,Long> {
}

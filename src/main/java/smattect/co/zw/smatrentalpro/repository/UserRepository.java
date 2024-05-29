package smattect.co.zw.smatrentalpro.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smattect.co.zw.smatrentalpro.utils.dao.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findUserByUserName(String username);

    Boolean existsByEmail(String email);

    void deleteByUserId(Long userId);
}

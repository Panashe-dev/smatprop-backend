package smattect.co.zw.smatrentalpro.utils.jwt;



import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import smattect.co.zw.smatrentalpro.repository.UserRepository;
import smattect.co.zw.smatrentalpro.utils.exception.BusinessValidationException;

@Service
@RequiredArgsConstructor
public class UserManager implements UserDetailsManager {

    private final UserRepository userRepository;
    @Override
    public void createUser(UserDetails user) {
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return userRepository.findByEmail(username).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findUserByUserName(username)
                .orElseThrow(() -> new BusinessValidationException("Bad credentials"));
    }
}

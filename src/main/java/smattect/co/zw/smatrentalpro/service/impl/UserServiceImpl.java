package smattect.co.zw.smatrentalpro.service.impl;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import smattect.co.zw.smatrentalpro.repository.RoleRepository;
import smattect.co.zw.smatrentalpro.repository.UserRepository;
import smattect.co.zw.smatrentalpro.repository.VerificationTokenRepository;
import smattect.co.zw.smatrentalpro.service.UserService;
import smattect.co.zw.smatrentalpro.utils.dao.Role;
import smattect.co.zw.smatrentalpro.utils.dao.User;
import smattect.co.zw.smatrentalpro.utils.dao.VerificationToken;
import smattect.co.zw.smatrentalpro.utils.dto.request.*;
import smattect.co.zw.smatrentalpro.utils.dto.response.ResponseMessage;
import smattect.co.zw.smatrentalpro.utils.exception.BusinessValidationException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserService {

    private  final UserRepository userRepository;
    private  final RoleRepository roleRepository;
    private final ApplicationEventPublisher publisher;
    private final VerificationTokenRepository verificationTokenRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User registerUser(UserRegistrationRequest userRegistrationRequest) {
        User user=new User();
        Set<Role> roles=new HashSet<>();
        Role role = roleRepository.findByRoleName("USER")
                .orElseThrow(() -> new BusinessValidationException("Failed to register your account, please try again"));
        Optional<User> userByUserName = userRepository.findUserByUserName(userRegistrationRequest.getUsernames());
        if (userByUserName.isPresent()){
            throw  new BusinessValidationException("Username already taken, please choose another one");
        }
        roles.add(role);
        user.setRoles(roles);
        user.setEmail(userRegistrationRequest.getEmail());
        user.setFirstName(userRegistrationRequest.getFirstName());
        user.setLastName(userRegistrationRequest.getLastName());
        user.setUserName(userRegistrationRequest.getUsernames());
        user.setPassword(passwordEncoder.encode(userRegistrationRequest.getPasswords()));
        user.setEnabled(true);
        return userRepository.save(user);
    }

    @Override
    public GetUserResponse getUserByUserEmail(String email) {
        return null;
    }

    @Override
    public GetUserResponse getUserByUserId(Long userId) {
        return null;
    }

    @Override
    public GetUserInfoResponse getUserInfo() {
        return null;
    }

    @Override
    public void updateUserPassword(UpdateUserPasswordRequest updateUserPasswordRequest) {
        User user = userRepository.findById(updateUserPasswordRequest.getUserId())
                .orElseThrow(() -> new BusinessValidationException("Account with that user does not exist"));
        user.setUserName(updateUserPasswordRequest.getUsername());
        user.setPassword(passwordEncoder.encode(updateUserPasswordRequest.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long userId) {
        User user = userRepository.findById(userId).
                orElseThrow(() -> new BusinessValidationException("Account with that user does not exist"));
        user.setDeleted(true);
        userRepository.save(user);
    }

    @Override
    public List<GetUserResponse> getAllUsers() {
        return null;
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken
                = new VerificationToken(user, token);
        verificationTokenRepository.save(verificationToken);
    }

    @Override
    public String validateVerificationToken(String token) {
        VerificationToken verificationToken
                = verificationTokenRepository.findByToken(token);

        if (verificationToken == null) {
            return "invalid token";
        }

        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();

        if ((verificationToken.getExpirationTime().getTime()
                - cal.getTime().getTime()) <= 0) {
            verificationTokenRepository.delete(verificationToken);
            return "expired";
        }

        user.setEnabled(true);
        userRepository.save(user);
        return "valid";
    }


    @Override
    public VerificationToken generateNewVerificationToken(String oldToken) {
        VerificationToken verificationToken
                = verificationTokenRepository.findByToken(oldToken);
        verificationToken.setToken(UUID.randomUUID().toString());
        verificationTokenRepository.save(verificationToken);
        return verificationToken;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(()->new BusinessValidationException(""));
    }

    @Override
    public void createPasswordResetTokenForUser(User user, String token) {
    }

    @Override
    public String validatePasswordResetToken(String token) {
      return  null;
    }

    @Override
    public Optional<User> getUserByPasswordResetToken(String token) {
        return Optional.empty();
    }

    @Override
    public void changePassword(User user, String newPassword) {

    }

    @Override
    public boolean checkIfValidOldPassword(User user, String oldPassword) {
        return false;
    }

    @Override
    public ResponseMessage activateUserAccount(ActivateRequest activateRequest) {
        return new ResponseMessage("success");
    }


}

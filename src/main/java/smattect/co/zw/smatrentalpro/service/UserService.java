package smattect.co.zw.smatrentalpro.service;






import jakarta.servlet.http.HttpServletRequest;
import smattect.co.zw.smatrentalpro.utils.dao.User;
import smattect.co.zw.smatrentalpro.utils.dao.VerificationToken;
import smattect.co.zw.smatrentalpro.utils.dto.request.*;
import smattect.co.zw.smatrentalpro.utils.dto.response.ResponseMessage;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(UserRegistrationRequest userRegistrationRequest);

    GetUserResponse getUserByUserEmail(String email);

    GetUserResponse getUserByUserId(Long userId);

    GetUserInfoResponse getUserInfo();

    void updateUserPassword(UpdateUserPasswordRequest updateUserPasswordRequest);

    void deleteUserById(Long userId);

    List<GetUserResponse> getAllUsers();

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);

    User findUserByEmail(String email);

    void createPasswordResetTokenForUser(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    void changePassword(User user, String newPassword);

    boolean checkIfValidOldPassword(User user, String oldPassword);

   ResponseMessage activateUserAccount(ActivateRequest activateRequest);
}

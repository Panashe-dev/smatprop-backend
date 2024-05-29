package smattect.co.zw.smatrentalpro.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smattect.co.zw.smatrentalpro.service.UserService;
import smattect.co.zw.smatrentalpro.utils.dao.User;
import smattect.co.zw.smatrentalpro.utils.dao.VerificationToken;
import smattect.co.zw.smatrentalpro.utils.dto.request.UpdateUserPasswordRequest;
import smattect.co.zw.smatrentalpro.utils.dto.request.UserRegistrationRequest;
import smattect.co.zw.smatrentalpro.utils.dto.response.ResponseMessage;
import smattect.co.zw.smatrentalpro.utils.event.RegistrationCompleteEvent;


import java.io.IOException;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/",
        produces = MediaType.APPLICATION_JSON_VALUE,
        headers = "Accept=application/json")
@Tag(name = "Registration Controller", description = "Registration Controller")
public class RegistrationController {

    private final UserService userService;

    private final ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public ResponseEntity<ResponseMessage> registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest,
                                                        final HttpServletRequest request) throws IOException {
        User user = userService.registerUser(userRegistrationRequest);
        publisher.publishEvent(new RegistrationCompleteEvent(
                user,
                applicationUrl(request)
        ));
        return ResponseEntity.ok(new ResponseMessage("registration success"));
    }



    @GetMapping("/verify/registration")
    public ResponseEntity<ResponseMessage> verifyRegistration(@RequestParam("token") String token) {
        String result = userService.validateVerificationToken(token);
        if(result.equalsIgnoreCase("valid")) {
            return  ResponseEntity.ok(new ResponseMessage("User Verified Successfully"));
        }
        return ResponseEntity.ok(new ResponseMessage("invalid token"));
    }
    @GetMapping("/resendVerifyToken")
    public String resendVerificationToken(@RequestParam("token") String oldToken,
                                          HttpServletRequest request) {
        VerificationToken verificationToken
                = userService.generateNewVerificationToken(oldToken);
        User user = verificationToken.getUser();
        resendVerificationTokenMail(user, applicationUrl(request), verificationToken);
        return "Verification Link Sent";
    }


    @PostMapping("/password/reset")
    public ResponseEntity<ResponseMessage> activateUser(@RequestBody UpdateUserPasswordRequest updateUserPasswordRequest) {
        userService.updateUserPassword(updateUserPasswordRequest);
        return ResponseEntity.ok(new ResponseMessage("success"));
    }

    private void resendVerificationTokenMail(User user, String applicationUrl, VerificationToken verificationToken) {
        String url =
                applicationUrl
                        + "/verifyRegistration?token="
                        + verificationToken.getToken();

        //sendVerificationEmail()
        log.info("Click the link to verify your account: {}",
                url);
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" +
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();
    }

}

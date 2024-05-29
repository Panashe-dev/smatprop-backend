package smattect.co.zw.smatrentalpro.utils.event.listener;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import smattect.co.zw.smatrentalpro.service.UserService;
import smattect.co.zw.smatrentalpro.utils.dao.User;
import smattect.co.zw.smatrentalpro.utils.email.SendEmailService;
import smattect.co.zw.smatrentalpro.utils.event.RegistrationCompleteEvent;

import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements
        ApplicationListener<RegistrationCompleteEvent> {

    private final UserService userService;
    private  final SendEmailService sendEmailService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);
        String url =
                event.getApplicationUrl()
                        + "/verifyRegistration?token="
                        + token;
        sendEmailService.emailNotification("SmatProp","registratin@cimas.co.zw",
                user.getEmail(),"SmatProp Verification Link","Click the link to verify your account: "+url);
        log.info("Click the link to verify your account: {}",
                url);
    }

}

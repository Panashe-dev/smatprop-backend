package smattect.co.zw.smatrentalpro.utils.event;



import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
import smattect.co.zw.smatrentalpro.utils.dao.User;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private final User user;
    private final String applicationUrl;

    public RegistrationCompleteEvent(User user, String applicationUrl) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }


}

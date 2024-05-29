package smattect.co.zw.smatrentalpro.utils.security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import smattect.co.zw.smatrentalpro.utils.dao.User;

import java.util.Optional;

@Service
public class SecurityUtils {

    public SecurityUtils() {
    }

    public static Optional<String> getCurrentLogInUser() {

        SecurityContext securityContext = SecurityContextHolder.getContext();

        return Optional.ofNullable(securityContext.getAuthentication())
                .map(authentication -> {
                    if (authentication.getPrincipal() instanceof UserDetails springSecurityUser) {
                        User users=(User)springSecurityUser;
                        return String.valueOf(users.getUserId());
                    } else if (authentication.getPrincipal() instanceof String) {
                        return (String) authentication.getPrincipal();
                    }
                    return null;
                });
    }

    public static Optional<String> getCurrentLogInUserEmail(){

        SecurityContext securityContext = SecurityContextHolder.getContext();

        return Optional.ofNullable(securityContext.getAuthentication())
                .map(authentication -> {
                    if (authentication.getPrincipal() instanceof UserDetails springSecurityUser) {
                        User users=(User)springSecurityUser;

                        return String.valueOf(users.getEmail());
                    } else if (authentication.getPrincipal() instanceof String) {
                        return (String) authentication.getPrincipal();
                    }
                    return null;
                });
    }

}

package smattect.co.zw.smatrentalpro.utils.jwt;




import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import smattect.co.zw.smatrentalpro.utils.dao.User;

import java.util.Collections;

@Component
public class GlobalJwtToUserConverter implements Converter<Jwt, UsernamePasswordAuthenticationToken> {

    @Override
    public UsernamePasswordAuthenticationToken convert(Jwt jwt) {
        User user = new User();
        user.setUserId(Long.valueOf(jwt.getSubject()));
        user.setEmail(jwt.getClaim("Email"));
        return new UsernamePasswordAuthenticationToken(user, jwt, Collections.EMPTY_LIST);
    }


}

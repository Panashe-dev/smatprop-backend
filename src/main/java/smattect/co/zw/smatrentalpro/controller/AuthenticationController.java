package smattect.co.zw.smatrentalpro.controller;



import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.web.bind.annotation.*;
import smattect.co.zw.smatrentalpro.utils.dto.request.LoginRequest;
import smattect.co.zw.smatrentalpro.utils.dto.response.TokenResponse;
import smattect.co.zw.smatrentalpro.utils.jwt.GlobalTokenGenerator;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Authentication Controller", description = "Authentication Controller")
@RequiredArgsConstructor
public class AuthenticationController {

    private  final GlobalTokenGenerator tokenGenerator;

    private  final DaoAuthenticationProvider daoAuthenticationProvider;

    @Qualifier("jwtRefreshTokenAuthProvider")
    JwtAuthenticationProvider refreshTokenAuthProvider;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = daoAuthenticationProvider.authenticate(UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.getUsername(),
                loginRequest.getPassword()));
        return ResponseEntity.ok(tokenGenerator.createToken(authentication));
    }

    @PostMapping("/token")
    public ResponseEntity token(@RequestBody TokenResponse tokenDTO) {
        Authentication authentication = refreshTokenAuthProvider.authenticate(new BearerTokenAuthenticationToken(tokenDTO.getRefreshToken()));
        Jwt jwt = (Jwt) authentication.getCredentials();
        return ResponseEntity.ok(tokenGenerator.createToken(authentication));
    }
}

package uz.mirkamol.learningspringsecurity.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static org.springframework.security.config.Elements.JWT;

@Component
@RequiredArgsConstructor
public class JwtDecoder {
    private final JwtProperties jwtProperties;
    public DecodedJWT decode(String token){
    return com.auth0.jwt.JWT.require(Algorithm.HMAC256(jwtProperties.getSecretKey()))
            .build()
            .verify(token);
    }
}

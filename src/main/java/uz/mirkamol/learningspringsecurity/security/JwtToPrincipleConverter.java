package uz.mirkamol.learningspringsecurity.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtToPrincipleConverter {

    public UserPrinciple convert(DecodedJWT jwt) {

        return UserPrinciple.builder()
                .userId(Long.parseLong(jwt.getSubject()))
                .email(jwt.getClaim("e").asString())
                .authorities(
                        extractAuthoritiesFormClaim(jwt)
                )
                .build();
    }

    private List<SimpleGrantedAuthority> extractAuthoritiesFormClaim(DecodedJWT jwt) {
        var claim = jwt.getClaim("a");
        if (claim.isNull() || claim.isMissing()) return List.of();

        return claim.asList(SimpleGrantedAuthority.class);
    }
}

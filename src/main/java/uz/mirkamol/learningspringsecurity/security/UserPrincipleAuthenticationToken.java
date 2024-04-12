package uz.mirkamol.learningspringsecurity.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


public class UserPrincipleAuthenticationToken extends AbstractAuthenticationToken {
    private final UserPrinciple userPrinciple;
    public UserPrincipleAuthenticationToken(UserPrinciple userPrinciple) {
        super(userPrinciple.getAuthorities());
        this.userPrinciple = userPrinciple;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public UserPrinciple getPrincipal() {
        return userPrinciple;
    }
}

package uz.mirkamol.learningspringsecurity.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.mirkamol.learningspringsecurity.entity.UserEntity;

import java.util.Optional;

@Service
public class UserService {
    private static final String EXISTING_EMAIL = "test@test.com";

    public Optional<UserEntity> findByEmail(String email) {
        // TODO: Move the to a database
        if (! EXISTING_EMAIL.equalsIgnoreCase(email)) return Optional.empty();

        var user = new UserEntity();
        user.setId(1L);
        user.setEmail(email);
        user.setPassword("$2a$12$qIYHwyFiTGKqGbr2qOFqw.6M.6Lad6wruewyPz6sCk7oFNlLO6B7q"); //test
        user.setRole("ROLE_ADMIN");
        user.setExtraInfo("My nice Admin");

        return Optional.of(user);
    }
}

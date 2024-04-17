package uz.mirkamol.learningspringsecurity.service;

import org.springframework.stereotype.Service;
import uz.mirkamol.learningspringsecurity.entity.UserEntity;

import java.util.Optional;

@Service
public class UserService {
    private static final String EXISTING_EMAIL = "test@test.com";
    private static final String ANOTHER_EMAIL = "next@test.com";

    public Optional<UserEntity> findByEmail(String email) {
        // TODO: Move the to a database

        if (EXISTING_EMAIL.equalsIgnoreCase(email)) {
            var user = new UserEntity();
            user.setId(1L);
            user.setEmail(email);
            user.setPassword("$2a$12$qIYHwyFiTGKqGbr2qOFqw.6M.6Lad6wruewyPz6sCk7oFNlLO6B7q"); //test
            user.setRole("ROLE_ADMIN");
            user.setExtraInfo("My nice Admin");

            return Optional.of(user);

        }else if (ANOTHER_EMAIL.equalsIgnoreCase(email)){
            var user = new UserEntity();
            user.setId(99L);
            user.setEmail(email);
            user.setPassword("$2a$12$qIYHwyFiTGKqGbr2qOFqw.6M.6Lad6wruewyPz6sCk7oFNlLO6B7q"); //test
            user.setRole("ROLE_USER");
            user.setExtraInfo("My nice User");

            return Optional.of(user);
        }
        return Optional.empty();

    }
}

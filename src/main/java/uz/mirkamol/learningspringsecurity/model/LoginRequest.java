package uz.mirkamol.learningspringsecurity.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginRequest {
    private String email, password;
}

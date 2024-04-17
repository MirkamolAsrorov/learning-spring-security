package uz.mirkamol.learningspringsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.mirkamol.learningspringsecurity.security.UserPrinciple;

@RestController
@RequiredArgsConstructor
public class HelloController {

    @GetMapping("/")
    public String greeting(){
        return "Hello, World";
    }

    @GetMapping("/secured")
    public String secured(@AuthenticationPrincipal UserPrinciple userPrinciple){
        return "if you see this, then you're logged in as user "  + userPrinciple.getEmail()
                + " user id " + userPrinciple.getUserId();
    }

    @GetMapping("/admin")
    public String checkAdmin(@AuthenticationPrincipal UserPrinciple userPrinciple){
        return "If you see this, then you are Admin. User ID: " + userPrinciple.getUserId();
    }
}

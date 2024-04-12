package uz.mirkamol.learningspringsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    @GetMapping("/")
    public String greeting(){
        return "Hello, World";
    }

    @GetMapping("/secured")
    public String secured(){
        return "if you see this, then you're logged in";
    }
}

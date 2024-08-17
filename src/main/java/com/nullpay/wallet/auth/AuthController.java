package com.nullpay.wallet.auth;


import com.nullpay.wallet.user.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {


    @PostMapping("/signup")
    public User signup() {
        return null;
        // signup logic
    }

    @PostMapping("/login")
    public User login() {
        return null;
        // login logic
    }
}

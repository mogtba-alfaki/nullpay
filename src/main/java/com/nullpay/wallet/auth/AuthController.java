package com.nullpay.wallet.auth;


import com.nullpay.wallet.auth.dto.SignupUserDto;
import com.nullpay.wallet.user.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public User signup(@RequestBody()SignupUserDto signupUserDto) {
        return this.authService.signup(signupUserDto);
    }

    @PostMapping("/login")
    public User login() {
        return null;
        // login logic
    }
}

package com.nullpay.wallet.auth;

import com.nullpay.wallet.auth.dto.SignupUserDto;
import com.nullpay.wallet.user.User;
import com.nullpay.wallet.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserService userService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }


    public User signup(SignupUserDto signupUserDto) throws ResponseStatusException {
        User userFound = this.userService.getUserByEmail(signupUserDto.getEmail());

        if(userFound != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with email already exists");
        }

        String password = signupUserDto.getPassword();
        signupUserDto.setPassword(this.passwordEncoder.encode(password));
        return this.userService.createUser(signupUserDto);
    }

    public void login() {
        // login logic
    }
}

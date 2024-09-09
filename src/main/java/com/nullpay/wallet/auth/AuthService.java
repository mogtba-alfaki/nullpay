package com.nullpay.wallet.auth;

import com.nullpay.wallet.auth.dto.LoginUserDto;
import com.nullpay.wallet.auth.dto.SignupUserDto;
import com.nullpay.wallet.config.security.JwtService;
import com.nullpay.wallet.user.User;
import com.nullpay.wallet.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(UserService userService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
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

    public String login(LoginUserDto loginUserDto) {
        User userFound = this.userService.getUserByEmail(loginUserDto.getEmail());
        if(userFound == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        boolean passwordMatches = this.passwordEncoder.matches(loginUserDto.getPassword(), userFound.getPassword());

        if(!passwordMatches) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid Credentials");
        }

        Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDto.getEmail(), loginUserDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = this.jwtService.generateToken(userFound);
        return jwt;
    }
}

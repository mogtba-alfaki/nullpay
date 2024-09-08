package com.nullpay.wallet.user.usecases;


import com.nullpay.wallet.auth.dto.SignupUserDto;
import com.nullpay.wallet.user.User;
import com.nullpay.wallet.user.UserRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateUserUseCase {
    private UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(SignupUserDto signupUserDto) {
        User user = new User();
        user.Id = String.valueOf(UUID.randomUUID());
        user.username = signupUserDto.getUsername();
        user.email = signupUserDto.getEmail();
        user.password = signupUserDto.getPassword();
        return this.userRepository.save(user);
    }

}

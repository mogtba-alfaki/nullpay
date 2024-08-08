package com.nullpay.wallet.user;


import com.nullpay.wallet.user.dto.CreateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired()
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserDto createUserDto) {
        User user = new User();
        user.Id = String.valueOf(UUID.randomUUID());
        user.username = createUserDto.username;
        user.email = createUserDto.email;
        user.password = createUserDto.password;
        return this.userRepository.save(user);
    }
}

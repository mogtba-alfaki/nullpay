package com.nullpay.wallet.user;


import com.nullpay.wallet.auth.dto.SignupUserDto;
import com.nullpay.wallet.user.usecases.CreateUserUseCase;
import com.nullpay.wallet.user.usecases.FindUsersUseCase;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final FindUsersUseCase findUsersUseCase;
    private final CreateUserUseCase createUserUseCase;

    public UserService(FindUsersUseCase findUsersUseCase, CreateUserUseCase createUserUseCase) {
        this.findUsersUseCase = findUsersUseCase;
        this.createUserUseCase = createUserUseCase;
    }

    public User createUser(SignupUserDto signupUserDto) {
        return this.createUserUseCase.create(signupUserDto);

    }

    public User getUserByEmail(String email) {
        return this.findUsersUseCase.byEmail(email);
    }

    public User getUserById(String userId) {
        return this.findUsersUseCase.byId(userId);
    }
}

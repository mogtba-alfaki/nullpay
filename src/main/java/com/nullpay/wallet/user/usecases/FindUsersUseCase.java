package com.nullpay.wallet.user.usecases;

import com.nullpay.wallet.user.User;
import com.nullpay.wallet.user.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class FindUsersUseCase {
    private final UserRepository userRepository;

    public FindUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User byId(String userId) {
        return this.userRepository.findById(userId).orElse(null);
    }

    public User byEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
}

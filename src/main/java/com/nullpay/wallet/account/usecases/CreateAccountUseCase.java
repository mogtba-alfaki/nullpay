package com.nullpay.wallet.account.usecases;

import com.nullpay.wallet.account.Account;
import com.nullpay.wallet.account.AccountRepository;
import com.nullpay.wallet.account.dto.CreateAccountDto;
import com.nullpay.wallet.user.User;
import com.nullpay.wallet.user.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Component
public class CreateAccountUseCase {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public CreateAccountUseCase(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    public Account createAccount(CreateAccountDto createAccountDto) {
        String userId = createAccountDto.getUserId();
        String accountTypeId = createAccountDto.getAccountTypeId();

        Optional<User> accountUser = this.userRepository.findById(userId);
        Account userAccountWithTheSameTypeExist = this.accountRepository.findByUserIdAndAccountTypeId(userId, accountTypeId);
        if(userAccountWithTheSameTypeExist != null) {
            throw new RuntimeException("User already has an account of this type");
        }

        Account account = new Account();
        account.setId(String.valueOf(UUID.randomUUID()));
        account.setAccountTypeId(accountTypeId);
        account.setUserId(userId);

        return this.accountRepository.save(account);
    }
}

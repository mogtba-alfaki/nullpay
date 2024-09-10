package com.nullpay.wallet.account;

import com.nullpay.wallet.account.dto.CreateAccountDto;
import com.nullpay.wallet.account.usecases.CreateAccountUseCase;
import com.nullpay.wallet.user.User;
import com.nullpay.wallet.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CreateAccountUseCase createAccountUseCase;

    @Autowired()
    public AccountService(AccountRepository accountRepository, CreateAccountUseCase createAccountUseCase, UserService userService) {
        this.accountRepository = accountRepository;
        this.createAccountUseCase = createAccountUseCase;
    }

    public List<Account> getAllAccounts() {
        return this.accountRepository.findAll();
    }

    public Account createAccount(CreateAccountDto createAccountDto) {
            return this.createAccountUseCase.createAccount(createAccountDto);
    }
}

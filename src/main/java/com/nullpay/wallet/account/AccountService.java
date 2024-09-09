package com.nullpay.wallet.account;

import com.nullpay.wallet.account.usecases.CreateAccountUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CreateAccountUseCase createAccountUseCase;

    @Autowired()
    public AccountService(AccountRepository accountRepository, CreateAccountUseCase createAccountUseCase) {
        this.accountRepository = accountRepository;
        this.createAccountUseCase = createAccountUseCase;
    }

    public List<Account> getAllAccounts() {
        return this.accountRepository.findAll();
    }

    public Account createAccount() {

    }
}

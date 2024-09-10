package com.nullpay.wallet.account;


import com.nullpay.wallet.account.dto.CreateAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired()
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return this.accountService.getAllAccounts();
    }

    @PostMapping
    public Account createAccount(@RequestBody() CreateAccountDto createAccountDto){
        return this.accountService.createAccount(createAccountDto);
    }
}

package com.nullpay.wallet.wallet.usecases;

import com.nullpay.wallet.account.Account;
import com.nullpay.wallet.account.AccountRepository;
import com.nullpay.wallet.transaction.TransactionRepository;
import com.nullpay.wallet.wallet.Wallet;
import com.nullpay.wallet.wallet.WalletRepository;
import com.nullpay.wallet.wallet.dto.WalletBalanceDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class GetWalletUseCase {
    private final WalletRepository walletRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public GetWalletUseCase(WalletRepository walletRepository, AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.walletRepository = walletRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public WalletBalanceDto walletBalance(String walletId) {
        Wallet wallet = this.walletRepository.findById(walletId).orElseThrow(() -> new RuntimeException("Wallet not found"));
        Account account = this.accountRepository.findById(wallet.accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        BigDecimal balance = this.transactionRepository.getWalletBalance(walletId);
        return new WalletBalanceDto(walletId, balance);
    }
}

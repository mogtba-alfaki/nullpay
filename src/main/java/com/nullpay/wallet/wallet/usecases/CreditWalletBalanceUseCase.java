package com.nullpay.wallet.wallet.usecases;

import com.nullpay.wallet.account.Account;
import com.nullpay.wallet.account.AccountRepository;
import com.nullpay.wallet.transaction.Transaction;
import com.nullpay.wallet.transaction.TransactionRepository;
import com.nullpay.wallet.transaction.enums.TransactionStatuses;
import com.nullpay.wallet.transaction.enums.TransactionTypes;
import com.nullpay.wallet.wallet.Wallet;
import com.nullpay.wallet.wallet.WalletRepository;
import com.nullpay.wallet.wallet.dto.CreditWalletBalanceDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Component
public class CreditWalletBalanceUseCase {
    private final WalletRepository walletRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public CreditWalletBalanceUseCase(WalletRepository walletRepository, AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.walletRepository = walletRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public Transaction creditBalance(CreditWalletBalanceDto creditWalletBalanceDto) {
        String walletId = creditWalletBalanceDto.getWalletId();
        BigDecimal amount = creditWalletBalanceDto.getAmount();

        Wallet wallet = this.walletRepository.findById(walletId).orElseThrow(() -> new RuntimeException("Wallet not found"));
        Optional<Account> walletAccount = this.accountRepository.findById(wallet.accountId);

        if(walletAccount.isEmpty()) {
            throw new RuntimeException("Account not found");
        }

        Transaction transaction = new Transaction();
        transaction.setId(UUID.randomUUID().toString());
        transaction.setAmount(amount);
        transaction.setStatus(TransactionStatuses.SUCCESS.name());
        transaction.setTransactionType(TransactionTypes.CREDIT.name());
        transaction.setWalletId(walletId);
        return this.transactionRepository.save(transaction);
    }
}

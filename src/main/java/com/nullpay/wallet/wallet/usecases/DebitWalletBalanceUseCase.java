package com.nullpay.wallet.wallet.usecases;

import com.nullpay.wallet.account.Account;
import com.nullpay.wallet.account.AccountRepository;
import com.nullpay.wallet.transaction.Transaction;
import com.nullpay.wallet.transaction.TransactionRepository;
import com.nullpay.wallet.transaction.enums.TransactionStatuses;
import com.nullpay.wallet.transaction.enums.TransactionTypes;
import com.nullpay.wallet.wallet.Wallet;
import com.nullpay.wallet.wallet.WalletRepository;
import com.nullpay.wallet.wallet.dto.DebitWalletBalanceDto;
import com.nullpay.wallet.wallet.dto.WalletBalanceDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Component
public class DebitWalletBalanceUseCase {
    private final WalletRepository walletRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public DebitWalletBalanceUseCase(WalletRepository walletRepository, AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.walletRepository = walletRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public Transaction debitBalance(DebitWalletBalanceDto debitWalletBalanceDto) {
        String walletId = debitWalletBalanceDto.getWalletId();
        BigDecimal amount = debitWalletBalanceDto.getAmount().abs();

        Wallet wallet = this.walletRepository.findById(walletId).orElseThrow(() -> new RuntimeException("Wallet Not Found"));
        Account walletAccount = this.accountRepository.findById(wallet.accountId).orElseThrow(() -> new RuntimeException("Account Not Found"));

        Transaction transaction = new Transaction();
        transaction.setId(UUID.randomUUID().toString());
        transaction.setAmount(amount.abs().negate());
        transaction.setStatus(TransactionStatuses.SUCCESS.name());
        transaction.setTransactionType(TransactionTypes.DEBIT.name());
        transaction.setWalletId(walletId);
        return this.transactionRepository.save(transaction);
    }
}

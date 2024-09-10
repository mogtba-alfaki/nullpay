package com.nullpay.wallet.wallet;

import com.nullpay.wallet.transaction.Transaction;
import com.nullpay.wallet.wallet.dto.CreateWalletDto;
import com.nullpay.wallet.wallet.dto.CreditWalletBalanceDto;
import com.nullpay.wallet.wallet.usecases.CreateWalletUseCase;
import com.nullpay.wallet.wallet.usecases.CreditWalletBalanceUseCase;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    private final CreateWalletUseCase createWalletUseCase;
    private final CreditWalletBalanceUseCase creditWalletBalanceUseCase;

    public WalletService(CreateWalletUseCase createWalletUseCase, CreditWalletBalanceUseCase creditWalletBalanceUseCase) {
        this.createWalletUseCase = createWalletUseCase;
        this.creditWalletBalanceUseCase = creditWalletBalanceUseCase;
    }

    public Wallet createWallet(CreateWalletDto createWalletDto) {
        return this.createWalletUseCase.createWallet(createWalletDto);
    }

    public Transaction creditWalletBalance(CreditWalletBalanceDto creditWalletBalanceDto) {
        return this.creditWalletBalanceUseCase.creditBalance(creditWalletBalanceDto);
    }
}

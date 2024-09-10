package com.nullpay.wallet.wallet;

import com.nullpay.wallet.transaction.Transaction;
import com.nullpay.wallet.wallet.dto.CreateWalletDto;
import com.nullpay.wallet.wallet.dto.CreditWalletBalanceDto;
import com.nullpay.wallet.wallet.dto.WalletBalanceDto;
import com.nullpay.wallet.wallet.usecases.CreateWalletUseCase;
import com.nullpay.wallet.wallet.usecases.CreditWalletBalanceUseCase;
import com.nullpay.wallet.wallet.usecases.GetWalletUseCase;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    private final CreateWalletUseCase createWalletUseCase;
    private final CreditWalletBalanceUseCase creditWalletBalanceUseCase;
    private final GetWalletUseCase getWalletUseCase;

    public WalletService(CreateWalletUseCase createWalletUseCase, CreditWalletBalanceUseCase creditWalletBalanceUseCase, GetWalletUseCase getWalletUseCase) {
        this.createWalletUseCase = createWalletUseCase;
        this.creditWalletBalanceUseCase = creditWalletBalanceUseCase;
        this.getWalletUseCase = getWalletUseCase;
    }

    public Wallet createWallet(CreateWalletDto createWalletDto) {
        return this.createWalletUseCase.createWallet(createWalletDto);
    }

    public Transaction creditWalletBalance(CreditWalletBalanceDto creditWalletBalanceDto) {
        return this.creditWalletBalanceUseCase.creditBalance(creditWalletBalanceDto);
    }

    public WalletBalanceDto getWalletBalance(String walletId) {
        return this.getWalletUseCase.walletBalance(walletId);
    }
}

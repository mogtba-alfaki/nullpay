package com.nullpay.wallet.wallet.usecases;

import com.nullpay.wallet.wallet.Wallet;
import com.nullpay.wallet.wallet.WalletRepository;
import com.nullpay.wallet.wallet.dto.CreateWalletDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateWalletUseCase {
    private final WalletRepository walletRepository;

    public CreateWalletUseCase(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto createWalletDto) {
        Wallet wallet = new Wallet();
        wallet.id = String.valueOf(UUID.randomUUID());
        wallet.setUserId(createWalletDto.getUserId());
        wallet.setAccountId(createWalletDto.getAccountId());
        wallet.setCardNumber(createWalletDto.getCardNumber());

        return this.walletRepository.save(wallet);
    }
}

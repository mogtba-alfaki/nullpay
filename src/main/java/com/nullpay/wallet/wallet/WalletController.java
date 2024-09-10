package com.nullpay.wallet.wallet;


import com.nullpay.wallet.transaction.Transaction;
import com.nullpay.wallet.wallet.dto.CreateWalletDto;
import com.nullpay.wallet.wallet.dto.CreditWalletBalanceDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wallets")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public Wallet createWallet(@RequestBody() CreateWalletDto createWalletDto) {
        return this.walletService.createWallet(createWalletDto);
    }

    @PostMapping("/credit")
    public Transaction credit(@RequestBody CreditWalletBalanceDto creditWalletBalanceDto) {
        return this.walletService.creditWalletBalance(creditWalletBalanceDto);
    }
}

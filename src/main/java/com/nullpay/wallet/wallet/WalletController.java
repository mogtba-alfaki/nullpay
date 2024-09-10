package com.nullpay.wallet.wallet;


import com.nullpay.wallet.transaction.Transaction;
import com.nullpay.wallet.wallet.dto.CreateWalletDto;
import com.nullpay.wallet.wallet.dto.CreditWalletBalanceDto;
import com.nullpay.wallet.wallet.dto.DebitWalletBalanceDto;
import com.nullpay.wallet.wallet.dto.WalletBalanceDto;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{walletId}/balance")
    public WalletBalanceDto getWalletBalance(@PathVariable("walletId") String walletId) {
        return this.walletService.getWalletBalance(walletId);
    }

    @PostMapping("/credit")
    public Transaction credit(@RequestBody CreditWalletBalanceDto creditWalletBalanceDto) {
        return this.walletService.creditWalletBalance(creditWalletBalanceDto);
    }

    @PostMapping("/debit")
    public Transaction debitWalletBalance(@RequestBody DebitWalletBalanceDto debitWalletBalanceDto) {
        return this.walletService.debitWalletBalance(debitWalletBalanceDto);
    }
}

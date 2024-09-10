package com.nullpay.wallet.wallet.dto;

import java.math.BigDecimal;

public class WalletBalanceDto {
    private String walletId;
    private BigDecimal balance;

    public WalletBalanceDto(String walletId, BigDecimal balance) {
        this.walletId = walletId;
        this.balance = balance;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "WalletBalanceDto{" +
                "walletId='" + walletId + '\'' +
                ", balance=" + balance +
                '}';
    }
}

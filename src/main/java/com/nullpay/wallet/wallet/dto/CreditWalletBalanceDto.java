package com.nullpay.wallet.wallet.dto;

import java.math.BigDecimal;

public class CreditWalletBalanceDto {
    private BigDecimal amount;
    private String walletId;
    private String referenceText;

    public CreditWalletBalanceDto(BigDecimal amount, String walletId, String referenceText) {
        this.amount = amount;
        this.walletId = walletId;
        this.referenceText = referenceText;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getReferenceText() {
        return referenceText;
    }

    public void setReferenceText(String referenceText) {
        this.referenceText = referenceText;
    }

    @Override
    public String toString() {
        return "CreditWalletBalanceDto{" +
                "amount=" + amount +
                ", walletId='" + walletId + '\'' +
                ", referenceText='" + referenceText + '\'' +
                '}';
    }
}

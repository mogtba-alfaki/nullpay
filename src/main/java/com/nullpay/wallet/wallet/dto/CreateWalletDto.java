package com.nullpay.wallet.wallet.dto;

public class CreateWalletDto {
    public String userId;
    public String accountId;
    public String cardNumber;

    public CreateWalletDto(String userId, String accountId, String cardNumber) {
        this.userId = userId;
        this.accountId = accountId;
        this.cardNumber = cardNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "CreateWalletDto{" +
                "userId='" + userId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}

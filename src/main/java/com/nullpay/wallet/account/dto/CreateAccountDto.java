package com.nullpay.wallet.account.dto;


import org.springframework.stereotype.Component;

public class CreateAccountDto {
    public String userId;
    public String accountTypeId;

    public CreateAccountDto(String userId, String accountTypeId) {
        this.userId = userId;
        this.accountTypeId = accountTypeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(String accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @Override
    public String toString() {
        return "CreateAccountDto{" +
                "userId='" + userId + '\'' +
                ", accountTypeId='" + accountTypeId + '\'' +
                '}';
    }
}

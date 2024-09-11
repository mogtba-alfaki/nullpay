package com.nullpay.wallet.transaction.enums;

public enum TransactionFees {
    USER_TRANSFER_FEE(0.33),
    MERCHANT_TRANSFER_FEE(0.50),
    ATM_TRANSFER_FEE(0.75);

    TransactionFees(double v) {
    }
}

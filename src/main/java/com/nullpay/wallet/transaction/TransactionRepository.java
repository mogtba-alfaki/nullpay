package com.nullpay.wallet.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.walletId = :walletId AND t.transactionType = 'CREDIT' AND t.status = 'SUCCESS'")
    BigDecimal getWalletBalance(String walletId);
}

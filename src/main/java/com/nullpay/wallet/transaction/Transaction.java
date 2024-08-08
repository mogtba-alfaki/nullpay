package com.nullpay.wallet.transaction;

import com.nullpay.wallet.wallet.Wallet;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Table(name = "transactions")
@Entity()
class Transaction {

    @Id()
    public String id;

    @Column(name = "wallet_id")
    public String walletId;

    @Column(name = "transaction_type")
    public String transactionType;

    @Column(name = "status")
    public String status;

    @Column(name = "amount")
    public BigDecimal amount;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @ManyToOne()
    @JoinColumn(name = "wallet_id", insertable = false, updatable = false)
    public Wallet wallet;

    public Transaction() {
    }

    public Transaction(String id, String walletId, String transactionType, String status, BigDecimal amount) {
        this.id = id;
        this.walletId = walletId;
        this.transactionType = transactionType;
        this.status = status;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", walletId='" + walletId + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                '}';
    }
}

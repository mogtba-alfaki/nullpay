package com.nullpay.wallet.wallet;


import com.nullpay.wallet.account.Account;
import com.nullpay.wallet.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Table(name = "wallets")
@Entity()
public class Wallet {
    @Id()
    public String id;

    @Column(name = "user_id")
    public String userId;

    @Column(name = "account_id")
    public String accountId;

    @Column(name = "card_number")
    public String cardNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    public User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", insertable = false, updatable = false)
    public Account account;



    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    public Wallet() {
    }

    public Wallet(String id, String userId, String accountId, String cardNumber) {
        this.id = id;
        this.userId = userId;
        this.accountId = accountId;
        this.cardNumber = cardNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "Wallet{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", user=" + user +
                ", account=" + account +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

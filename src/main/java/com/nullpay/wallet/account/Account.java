package com.nullpay.wallet.account;


import com.nullpay.wallet.account_type.AccountType;
import com.nullpay.wallet.user.User;
import com.nullpay.wallet.wallet.Wallet;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Set;

@Entity()
@Table(name = "accounts")
public class Account {

    @Id()
    public String Id;

    @Column(name = "user_id")
    public String userId;

    @Column(name = "account_type_id")
    public String accountTypeId;


    @ManyToOne()
    @JoinColumn(name = "account_type_id", nullable = false, insertable = false, updatable = false)
    private AccountType accountType;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    public User user;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    public Set<Wallet> wallets;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    public Account() {
    }

    public Account(String id, String userId, String accountTypeId) {
        this.Id = id;
        this.userId = userId;
        this.accountTypeId = accountTypeId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
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
        return "Account{" +
                "id='" + Id + '\'' +
                ", userId='" + userId + '\'' +
                ", accountTypeId='" + accountTypeId + '\'' +
                '}';
    }
}

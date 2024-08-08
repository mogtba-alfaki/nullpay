package com.nullpay.wallet.user;


import com.nullpay.wallet.account.Account;
import com.nullpay.wallet.wallet.Wallet;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Set;

@Table(name = "users")
@Entity()
public class User {

    @Id
    public String Id;

    @Column(name = "username")
    public String username;

    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    public Set<Account> accounts;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    public Set<Wallet> wallets;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;
}

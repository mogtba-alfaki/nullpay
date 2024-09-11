package com.nullpay.wallet.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
     Account findByUserIdAndAccountTypeId(String userId, String accountTypeId);
}

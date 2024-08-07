package com.nullpay.wallet.account_type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Table(name = "account_types")
@Entity()
public class AccountType {
    @Id
    public String Id;

    @Column(name = "type_name")
    public String typeName;

    @Column(name = "description")
    public String typeDescription;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    public AccountType() {
    }

    public AccountType(String id, String typeName, String typeDescription) {
        Id = id;
        this.typeName = typeName;
        this.typeDescription = typeDescription;
    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }
}

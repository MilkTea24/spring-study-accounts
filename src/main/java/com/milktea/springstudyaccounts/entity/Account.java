package com.milktea.springstudyaccounts.entity;

import com.milktea.springstudyaccounts.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Table(name = "account_tb")
public class Account extends BaseEntity {
    @Column(nullable = false)
    private BigDecimal balance;

    protected Account() {}

    public Account(BigDecimal balance) {
        this.balance = balance;
    }
}

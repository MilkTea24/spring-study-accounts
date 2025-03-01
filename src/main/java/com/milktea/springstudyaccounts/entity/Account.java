package com.milktea.springstudyaccounts.entity;

import com.milktea.springstudyaccounts.utils.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

@Entity
@Table(name = "account_tb")
public class Account extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    private BigDecimal balance;

    public Account(BigDecimal balance) {
        this.balance = balance;
    }
}

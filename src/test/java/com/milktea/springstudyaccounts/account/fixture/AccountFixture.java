package com.milktea.springstudyaccounts.account.fixture;

import com.milktea.springstudyaccounts.entity.Account;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class AccountFixture {
    private AccountFixture() {}

    public static AccountTestDataBuilder builder() {
        return new AccountTestDataBuilder();
    }

    public static class AccountTestDataBuilder {
        private BigDecimal balance = BigDecimal.ZERO;


        public AccountTestDataBuilder withBalance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public Account build() {
            return new Account(balance);
        }
    }
}

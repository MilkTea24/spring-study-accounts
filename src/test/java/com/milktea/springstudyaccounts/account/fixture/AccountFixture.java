package com.milktea.springstudyaccounts.account.fixture;

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
        private final Instant instant = Instant.parse("2025-01-01T00:00:00Z");
        private Long id;
        private BigDecimal balance = BigDecimal.ZERO;
        private LocalDateTime createdAt = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));
        private LocalDateTime updatedAt = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));

        public AccountTestDataBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public AccountTestDataBuilder withBalance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public AccountTestDataBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AccountTestDataBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Account build() {
            return new Account(id, balance, createdAt, updatedAt);
        }
    }
}

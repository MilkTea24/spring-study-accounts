package com.milktea.springstudyaccounts.account.fixture;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TransactionFixture {
    private TransactionFixture() {}

    public static Transaction builder() {
        return new TransactionTestDataBuilder();
    }

    public static class TransactionTestDataBuilder {
        private final Instant instant = Instant.parse("2025-01-01T00:00:00Z");
        private Long id;
        private BigDecimal amount;
        private TransactionType transactionType = TransactionType.ACCUMULATE;
        private LocalDateTime createdAt = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));
        private LocalDateTime updatedAt = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));

        public TransactionTestDataBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public TransactionTestDataBuilder withAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public TransactionTestDataBuilder withTransactionType(TransactionType transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public TransactionTestDataBuilder withCreatedAtAndUpdatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            this.updatedAt = createdAt;
            return this;
        }

        public Transaction build() {
            return new Transaction(id, amount, transactionType, createdAt, updatedAt);
        }

    }
}

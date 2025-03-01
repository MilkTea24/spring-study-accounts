package com.milktea.springstudyaccounts.account.fixture;

import com.milktea.springstudyaccounts.entity.Account;
import com.milktea.springstudyaccounts.entity.Transaction;
import com.milktea.springstudyaccounts.entity.TransactionType;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TransactionFixture {
    private TransactionFixture() {}

    public static TransactionTestDataBuilder builder() {
        return new TransactionTestDataBuilder();
    }

    public static class TransactionTestDataBuilder {
        private BigDecimal amount = BigDecimal.ZERO;
        private TransactionType transactionType = TransactionType.DEPOSIT;
        private Account account = AccountFixture.builder().build();


        public TransactionTestDataBuilder withAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public TransactionTestDataBuilder withTransactionType(TransactionType transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public TransactionTestDataBuilder withAccount(Account account) {
            this.account = account;
            return this;
        }

        public Transaction build() {
            return new Transaction(account, amount, transactionType);
        }

    }
}

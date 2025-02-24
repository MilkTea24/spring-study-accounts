package com.milktea.springstudyaccounts.account.entity;

import com.milktea.springstudyaccounts.account.fixture.TransactionFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TransactionRepositoryTest {
    @Autowired
    TransactionRepository transactionRepository;

    @Test
    @DisplayName("성공적으로 저장되는지 확인")
    void save_transaction_success_test() {
        //given
        Transaction transaction = TransactionFixture.builder().build();

        //when
        Transaction savedTransaction = transactionRepository.save(transaction);

        //then
        Assertions.assertNotNull(savedtransaction.getId());
    }

    @Test
    @DisplayName("성공적으로 Id로 조회할 수 있는지 확인")
    void find_by_id_transaction_success_test() {
        //given
        Transaction savedTransaction = transactionRepository.save(TransactionFixture.builder().build());
        Transaction savedSecondTransaction = transactionRepository.save(TransactionFixture.builder().build());

        //when
        Transaction findTransaction = transactionRepository.findById(savedTransaction.getId());
        Transaction secondTransaction = transactionRepository.findById(savedSecondTransaction.getId());

        //then
        Assertions.assertEquals(savedSecondTransaction.getId(), secondTransaction.getId());
    }

}

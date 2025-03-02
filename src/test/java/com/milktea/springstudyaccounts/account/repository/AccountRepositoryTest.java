package com.milktea.springstudyaccounts.account.repository;

import com.milktea.springstudyaccounts.account.fixture.AccountFixture;
import com.milktea.springstudyaccounts.entity.Account;
import com.milktea.springstudyaccounts.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class AccountRepositoryTest {
    @Autowired
    private AccountRepository accountRepository;

    @Test
    @DisplayName("성공적으로 저장되는지 확인")
    void save_account_success_test() {
        //given
        Account account = AccountFixture.builder().build();

        //when
        Account savedAccount = accountRepository.save(account);

        //then
        Assertions.assertNotNull(savedAccount.getId());
    }

    @Test
    @DisplayName("성공적으로 Id로 조회할 수 있는지 확인")
    void find_by_id_account_success_test() {
        //given
        Account savedAccount = accountRepository.save(AccountFixture.builder().build());
        Account savedSecondAccount = accountRepository.save(AccountFixture.builder().build());

        //when
        Account findAccount = accountRepository.findById(savedAccount.getId()).get();
        Account findSecondAccount = accountRepository.findById(savedSecondAccount.getId()).get();

        //then
        Assertions.assertEquals(findSecondAccount.getId(), savedSecondAccount.getId());
    }
}

package com.milktea.springstudyaccounts.account.repository;

import com.milktea.springstudyaccounts.account.fixture.AccountFixture;
import com.milktea.springstudyaccounts.account.stub.StubAccountRepository;
import com.milktea.springstudyaccounts.entity.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class StubAccountRepositoryTest {
    StubAccountRepository stubAccountRepository;

    @BeforeEach
    public void setup() {
        stubAccountRepository = new StubAccountRepository();
    }

    @Test
    @DisplayName("stub save 성공 테스트")
    public void stub_repository_save_success_test() {
        //given
        Account account = AccountFixture.builder().build();

        //when
        Account savedAccount = stubAccountRepository.save(account);

        //then
        Assertions.assertEquals(1, savedAccount.getId());
    }

    @Test
    @DisplayName("stub saveAll 성공 테스트")
    public void stub_repository_save_all_success_test() {
        //given
        List<Account> accounts = new ArrayList<>();
        accounts.add(AccountFixture.builder().build());
        accounts.add(AccountFixture.builder().build());


        //when
        List<Account> savedAccounts = (List<Account>) stubAccountRepository.saveAll(accounts);

        //then
        Assertions.assertEquals(2, savedAccounts.get(1).getId());
    }

    @Test
    @DisplayName("stub findById 성공 테스트")
    public void stub_repository_find_by_id_success_test() {
        //given
        stubAccountRepository.save(AccountFixture.builder().build());
        stubAccountRepository.save(AccountFixture.builder().build());

        //when, then
        Assertions.assertFalse(stubAccountRepository.findById(2L).isEmpty());
    }

    @Test
    @DisplayName("stub findById 실패 테스트")
    public void stub_repository_find_by_id_fail_test() {
        //given
        stubAccountRepository.save(AccountFixture.builder().build());

        //when, then
        Assertions.assertTrue(stubAccountRepository.findById(2L).isEmpty());
    }

    @Test
    @DisplayName("stub existsById 성공 테스트")
    public void stub_repository_exists_by_id_success_test() {
        //given
        stubAccountRepository.save(AccountFixture.builder().build());
        stubAccountRepository.save(AccountFixture.builder().build());

        //when, then
        Assertions.assertTrue(stubAccountRepository.existsById(2L));
    }

    @Test
    @DisplayName("stub existsById 실패 테스트")
    public void stub_repository_exists_by_id_fail_test() {
        //given
        stubAccountRepository.save(AccountFixture.builder().build());

        //when, then
        Assertions.assertFalse(stubAccountRepository.existsById(2L));
    }

    @Test
    @DisplayName("count 테스트")
    public void stub_repository_count_success_test() {
        //given
        for (int i = 0; i < 5; i++) {
            stubAccountRepository.save(AccountFixture.builder().build());
        }

        //when, then
        Assertions.assertEquals(5, stubAccountRepository.count());
    }

    @Test
    @DisplayName("deleteById 성공 테스트")
    public void stub_repository_delete_by_id_success_test() {
        //given
        stubAccountRepository.save(AccountFixture.builder().build());
        stubAccountRepository.save(AccountFixture.builder().build());

        //when
        stubAccountRepository.deleteById(2L);

        //then
        Assertions.assertFalse(stubAccountRepository.existsById(2L));
    }

    @Test
    @DisplayName("deleteById 실패 테스트")
    public void stub_repository_delete_by_id_fail_test() {
        //given
        stubAccountRepository.save(AccountFixture.builder().build());
        stubAccountRepository.save(AccountFixture.builder().build());

        //when
        stubAccountRepository.deleteById(3L);

        //then
        Assertions.assertEquals(2L, stubAccountRepository.count());
    }

    @Test
    @DisplayName("delete 성공 테스트")
    public void stub_repository_delete_success_test() {
        //given
        Account deleteAccount = AccountFixture.builder().build();
        stubAccountRepository.save(deleteAccount);

        //when
        stubAccountRepository.delete(deleteAccount);

        //then
        Assertions.assertEquals(0L, stubAccountRepository.count());
    }

    @Test
    @DisplayName("delete 실패 테스트")
    public void stub_repository_delete_fail_test() {
        //given
        Account saveAccount = AccountFixture.builder().build();
        Account deleteAccount = AccountFixture.builder().build();
        stubAccountRepository.save(saveAccount);

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> stubAccountRepository.delete(deleteAccount));
    }

    @Test
    @DisplayName("deleteAllById 성공 테스트")
    public void stub_repository_delete_all_by_id_success_test() {
        //given
        for (int i = 0; i < 5; i++) {
            stubAccountRepository.save(AccountFixture.builder().build());
        }
        List<Long> deleteIds = List.of(2L, 4L);

        //when
        stubAccountRepository.deleteAllById(deleteIds);

        //then
        Assertions.assertFalse(stubAccountRepository.existsById(2L));
        Assertions.assertFalse(stubAccountRepository.existsById(4L));
    }

    @Test
    @DisplayName("deleteAll 성공 테스트")
    public void stub_repository_delete_all_success_test() {
        //given
        List<Account> deleteAccounts = new ArrayList<>();
        stubAccountRepository.save(AccountFixture.builder().build());
        deleteAccounts.add(stubAccountRepository.save(AccountFixture.builder().build()));
        stubAccountRepository.save(AccountFixture.builder().build());
        deleteAccounts.add(stubAccountRepository.save(AccountFixture.builder().build()));
        stubAccountRepository.save(AccountFixture.builder().build());

        //when
        stubAccountRepository.deleteAll(deleteAccounts);

        //then
        Assertions.assertFalse(stubAccountRepository.existsById(2L));
        Assertions.assertFalse(stubAccountRepository.existsById(4L));
    }

    @Test
    @DisplayName("deleteAll 실패 테스트")
    public void stub_repository_delete_all_fail_test() {
        //given
        List<Account> deleteAccounts = new ArrayList<>();
        stubAccountRepository.save(AccountFixture.builder().build());
        deleteAccounts.add(stubAccountRepository.save(AccountFixture.builder().build()));
        deleteAccounts.add(AccountFixture.builder().build());

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> stubAccountRepository.deleteAll(deleteAccounts));
    }

    @Test
    @DisplayName("deleteAll() 성공 테스트")
    public void stub_repository_delete_clear_test() {
        //given
        for (int i = 0; i < 5; i++) {
            stubAccountRepository.save(AccountFixture.builder().build());
        }

        //when
        stubAccountRepository.deleteAll();

        //then
        Assertions.assertEquals(0L, stubAccountRepository.count());
    }
}

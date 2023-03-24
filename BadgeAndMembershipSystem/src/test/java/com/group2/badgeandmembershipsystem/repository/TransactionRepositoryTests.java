package com.group2.badgeandmembershipsystem.repository;

import com.group2.badgeandmembershipsystem.domain.Transaction;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.testng.AssertJUnit.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TransactionRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void findByTransactionId_thenReturnTransaction(){
        Transaction transaction = new Transaction(LocalDateTime.now(),"ACCEPTED");
        entityManager.persist(transaction);
        entityManager.flush();
        Optional<Transaction> optionalTransaction = transactionRepository.findById(transaction.getId());
        assertTrue(optionalTransaction.isPresent());
        Transaction found = optionalTransaction.get();
        AssertionsForInterfaceTypes.assertThat(found.getId()).isEqualTo(transaction.getId());
    }
}

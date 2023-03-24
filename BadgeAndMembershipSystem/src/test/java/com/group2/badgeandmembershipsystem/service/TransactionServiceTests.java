package com.group2.badgeandmembershipsystem.service;

import com.group2.badgeandmembershipsystem.domain.Transaction;
import com.group2.badgeandmembershipsystem.dto.TransactionDTO;
import com.group2.badgeandmembershipsystem.repository.TransactionRepository;
import com.group2.badgeandmembershipsystem.service.impl.TransactionServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@TestConfiguration
public class TransactionServiceTests {
    @TestConfiguration
    static class TransactionServiceTestContextConfiguration{
        @Bean
        public TransactionService transactionService() {
            return new TransactionServiceImpl();
        }
        @Bean
        public ModelMapper modelMapper(){
            return new ModelMapper();
        }
    }
    @Autowired
    private TransactionService transactionService;
    @MockBean
    private TransactionRepository transactionRepository;
    @Before
    public void setUp(){
        long transactionId = 1L;
        Transaction transaction = new Transaction(LocalDateTime.now(),"ACCEPTED");
        Optional<Transaction> transactionOptional = Optional.of(transaction);
        Mockito.when(transactionRepository.findById(transactionId)).thenReturn(transactionOptional);
    }
    @Test
    public void whenValidTransactionIdThenTransactionShouldBeFound(){
        String transactionType = "ACCEPTED";
        long transactionId = 1L;
        TransactionDTO found = transactionService.getTransaction(transactionId);
        assertThat(found.getTransactionType())
                .isEqualTo(transactionType);
    }
}

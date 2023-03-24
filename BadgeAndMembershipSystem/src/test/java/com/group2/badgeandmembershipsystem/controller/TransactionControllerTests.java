package com.group2.badgeandmembershipsystem.controller;

import com.group2.badgeandmembershipsystem.dto.TransactionDTO;
import com.group2.badgeandmembershipsystem.repository.TransactionRepository;
import com.group2.badgeandmembershipsystem.security.JwtFilter;
import com.group2.badgeandmembershipsystem.security.JwtHelper;
import com.group2.badgeandmembershipsystem.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionController.class)
@AutoConfigureMockMvc(addFilters = false)
public class TransactionControllerTests {
    @Autowired
    private MockMvc mock;

    @MockBean
    private JwtFilter jwtFilter;
    @MockBean
    private JwtHelper jwtHelper;
    @MockBean
    private TransactionService transactionService;
    @MockBean
    private TransactionRepository transactionRepository;

    @Test
    public void testGetTransactionByTransactionId() throws Exception{
        Mockito.when(transactionService.getTransaction(1L)).thenReturn(new TransactionDTO(LocalDateTime.now(),"ACCEPTED"));
        mock.perform(MockMvcRequestBuilders.get("/api/transactions/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.transactionType").value("ACCEPTED"));
    }
}

package com.group2.badgeandmembershipsystem.service;

import com.group2.badgeandmembershipsystem.dto.TransactionDTO;
import com.group2.badgeandmembershipsystem.dto.TransactionRequestDTO;
import com.group2.badgeandmembershipsystem.exception.payload.ApiResponse;

import java.util.List;

public interface TransactionService {
    ApiResponse createTransaction(TransactionRequestDTO transactionDTO);
    TransactionDTO getTransaction(long id);
    void deleteTransaction(long id);
    List<TransactionDTO> getAllTransactions();
    TransactionDTO updateTransaction(long id, TransactionDTO transactionDTO);
}

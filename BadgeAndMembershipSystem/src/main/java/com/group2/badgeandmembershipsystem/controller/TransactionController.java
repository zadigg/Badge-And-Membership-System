package com.group2.badgeandmembershipsystem.controller;

import com.group2.badgeandmembershipsystem.dto.TransactionDTO;
import com.group2.badgeandmembershipsystem.dto.TransactionRequestDTO;
import com.group2.badgeandmembershipsystem.exception.payload.ApiResponse;
import com.group2.badgeandmembershipsystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/transactions")
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @PostMapping
    public ResponseEntity<ApiResponse> createTransaction(@RequestBody TransactionRequestDTO transaction){
        ApiResponse response = transactionService.createTransaction(transaction);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> getAllTransactions(){
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.getAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransaction(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.getTransaction(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionDTO> updateTransaction(@PathVariable Long id, @RequestBody TransactionDTO transaction){
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.updateTransaction(id,transaction));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> deleteTransaction(@PathVariable Long id){
        transactionService.deleteTransaction(id);
        ApiResponse response = ApiResponse.builder().message("Transaction is deleted successfully").success(true).status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

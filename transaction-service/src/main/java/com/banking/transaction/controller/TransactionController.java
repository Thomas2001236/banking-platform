// TransactionController.java
package com.banking.transaction.controller;

import com.banking.transaction.model.Transaction;
import com.banking.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService service;

    @PostMapping
    public Transaction create(@RequestBody Transaction tx) { return service.createTransaction(tx); }

    @GetMapping
    public List<Transaction> getAll() { return service.getAll(); }
}

// AccountController.java
package com.banking.account.controller;

import com.banking.account.model.Account;
import com.banking.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService service;

    @GetMapping
    public List<Account> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Account get(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Account create(@RequestBody Account account) { return service.create(account); }

    @PutMapping("/{id}")
    public Account update(@PathVariable Long id, @RequestBody Account account) {
        account.setId(id);
        return service.update(account);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}

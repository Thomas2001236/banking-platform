// AccountService.java
package com.banking.account.service;

import com.banking.account.model.Account;
import com.banking.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository repository;

    public List<Account> getAll() { return repository.findAll(); }
    public Account getById(Long id) { return repository.findById(id).orElseThrow(); }
    public Account create(Account account) { return repository.save(account); }
    public Account update(Account account) { return repository.save(account); }
    public void delete(Long id) { repository.deleteById(id); }
}

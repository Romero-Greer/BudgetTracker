package com.budget.budgettracker.service;

import com.budget.budgettracker.model.CheckingAccount;
import com.budget.budgettracker.repository.CheckingAccountRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CheckingAccountService {

    private final CheckingAccountRepository repository;

    public CheckingAccountService(CheckingAccountRepository repository) {
        this.repository = repository;
    }

    public List<CheckingAccount> findAll() {
        return repository.findAll();
    }

    public Optional<CheckingAccount> findById(Long id) {
        return repository.findById(id);
    }

    public CheckingAccount save(CheckingAccount checkingAccount) {
        return repository.save(checkingAccount);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

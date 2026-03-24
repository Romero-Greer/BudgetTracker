package com.budget.budgettracker.service;

import com.budget.budgettracker.model.AccountType;
import com.budget.budgettracker.repository.AccountTypeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountTypeService {

    private final AccountTypeRepository repository;

    public AccountTypeService(AccountTypeRepository repository) {
        this.repository = repository;
    }

    public List<AccountType> findAll() {
        return repository.findAll();
    }

    public Optional<AccountType> findById(Long id) {
        return repository.findById(id);
    }

    public AccountType save(AccountType accountType) {
        return repository.save(accountType);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
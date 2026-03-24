package com.budget.budgettracker.service;

import com.budget.budgettracker.model.SavingsAccount;
import com.budget.budgettracker.repository.SavingsAccountRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SavingsAccountService {

    private final SavingsAccountRepository repository;

    public SavingsAccountService(SavingsAccountRepository repository) {
        this.repository = repository;
    }

    public List<SavingsAccount> findAll() {
        return repository.findAll();
    }

    public Optional<SavingsAccount> findById(Long id) {
        return repository.findById(id);
    }

    public SavingsAccount save(SavingsAccount savingsAccount) {
        return repository.save(savingsAccount);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

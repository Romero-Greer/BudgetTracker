package com.budget.budgettracker.service;

import com.budget.budgettracker.model.Transaction;
import com.budget.budgettracker.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> findAll() {
        return repository.findAll();
    }

    public Optional<Transaction> findById(Long id) {
        return repository.findById(id);
    }

    public List<Transaction> findByAccountId(Long accountId) {
        return repository.findByAccountType_AccountId(accountId);
    }

    public Transaction save(Transaction transaction) {
        return repository.save(transaction);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

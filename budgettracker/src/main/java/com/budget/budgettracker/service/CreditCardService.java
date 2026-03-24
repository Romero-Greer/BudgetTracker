package com.budget.budgettracker.service;

import com.budget.budgettracker.model.CreditCard;
import com.budget.budgettracker.repository.CreditCardRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService {

    private final CreditCardRepository repository;

    public CreditCardService(CreditCardRepository repository) {
        this.repository = repository;
    }

    public List<CreditCard> findAll() {
        return repository.findAll();
    }

    public Optional<CreditCard> findById(Long id) {
        return repository.findById(id);
    }

    public CreditCard save(CreditCard creditCard) {
        return repository.save(creditCard);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

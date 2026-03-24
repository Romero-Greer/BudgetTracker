package com.budget.budgettracker.controller;

import com.budget.budgettracker.model.SavingsAccount;
import com.budget.budgettracker.service.SavingsAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/savings")
public class SavingsAccountController {

    private final SavingsAccountService service;

    public SavingsAccountController(SavingsAccountService service) {
        this.service = service;
    }

    @GetMapping
    public List<SavingsAccount> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingsAccount> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SavingsAccount create(@RequestBody SavingsAccount savingsAccount) {
        return service.save(savingsAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SavingsAccount> update(@PathVariable Long id, @RequestBody SavingsAccount updated) {
        return service.findById(id).map(existing -> {
            existing.setTotalAmount(updated.getTotalAmount());
            return ResponseEntity.ok(service.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

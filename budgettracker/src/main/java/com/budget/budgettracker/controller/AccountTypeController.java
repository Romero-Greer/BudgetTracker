package com.budget.budgettracker.controller;

import com.budget.budgettracker.model.AccountType;
import com.budget.budgettracker.service.AccountTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/account-types")
public class AccountTypeController {

    private final AccountTypeService service;

    public AccountTypeController(AccountTypeService service) {
        this.service = service;
    }

    @GetMapping
    public List<AccountType> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountType> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AccountType create(@RequestBody AccountType accountType) {
        return service.save(accountType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountType> update(@PathVariable Long id, @RequestBody AccountType updated) {
        return service.findById(id).map(existing -> {
            existing.setName(updated.getName());
            return ResponseEntity.ok(service.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

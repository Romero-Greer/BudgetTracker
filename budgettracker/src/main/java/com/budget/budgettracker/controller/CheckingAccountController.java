package com.budget.budgettracker.controller;

import com.budget.budgettracker.model.CheckingAccount;
import com.budget.budgettracker.service.CheckingAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/checking")
public class CheckingAccountController {

    private final CheckingAccountService service;

    public CheckingAccountController(CheckingAccountService service) {
        this.service = service;
    }

    @GetMapping
    public List<CheckingAccount> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CheckingAccount> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CheckingAccount create(@RequestBody CheckingAccount checkingAccount) {
        return service.save(checkingAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CheckingAccount> update(@PathVariable Long id, @RequestBody CheckingAccount updated) {
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

package com.budget.budgettracker.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "checking_account")
public class CheckingAccount {

    @Id
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "total_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal totalAmount;

    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    private AccountType accountType;

    // Getters and Setters
    public Long getAccountId() { return accountId; }
    public void setAccountId(Long accountId) { this.accountId = accountId; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public AccountType getAccountType() { return accountType; }
    public void setAccountType(AccountType accountType) { this.accountType = accountType; }
}

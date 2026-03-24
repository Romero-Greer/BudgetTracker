package com.budget.budgettracker.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "credit_card")
public class CreditCard {

    @Id
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "total_due", precision = 12, scale = 2)
    private BigDecimal totalDue;

    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    private AccountType accountType;

    // Getters and Setters
    public Long getAccountId() { return accountId; }
    public void setAccountId(Long accountId) { this.accountId = accountId; }
    public BigDecimal getTotalDue() { return totalDue; }
    public void setTotalDue(BigDecimal totalDue) { this.totalDue = totalDue; }
    public AccountType getAccountType() { return accountType; }
    public void setAccountType(AccountType accountType) { this.accountType = accountType; }
}

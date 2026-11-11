
package com.example.bankapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bank_transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", precision = 38, scale = 2)
    private BigDecimal amount;

    @Column(name = "transaction_date")
    private LocalDateTime createdAt;

    @Column(name = "reference_number")
    private String description;

    @Column(name = "sender_account")
    private String fromAccount;

    @Column(name = "receiver_account")
    private String toAccount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TransactionStatus status;
}

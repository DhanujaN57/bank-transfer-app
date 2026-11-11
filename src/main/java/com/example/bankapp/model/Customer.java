
package com.example.bankapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    public static final String BANK_ACCOUNT_NUMBER = "999999";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Pattern(
        regexp = "\\d{6}",
        message = "Account number must contain exactly 6 digits"
    )
    @Column(
        name = "account_number",
        unique = true,
        nullable = false,
        length = 6
    )
    private String accountNumber;

    @NotBlank
    @Column(name = "name", length = 100, nullable = false)
    private String fullName;

    @NotBlank
    @Email
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @NotNull
    @DecimalMin(value = "0.00")
    @Digits(integer = 12, fraction = 2)
    @Column(
        name = "balance",
        precision = 14,
        scale = 2,
        nullable = false
    )
    private BigDecimal balance;
}

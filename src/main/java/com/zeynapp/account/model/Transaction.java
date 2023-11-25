package com.zeynapp.account.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode
@Data
public class Transaction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Builder.Default
    private TransactionType transactionType = TransactionType.INITIAL;
    private BigDecimal amount;
    @Builder.Default
    private LocalDateTime transactionDate = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "account", nullable = false)
    private Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction that)) return false;
        return Objects.equals(id, that.id) && transactionType == that.transactionType && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionType, amount, transactionDate);
    }
}

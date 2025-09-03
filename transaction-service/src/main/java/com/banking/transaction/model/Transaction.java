// Transaction.java
package com.banking.transaction.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long fromAccount;
    private Long toAccount;
    private double amount;
    private LocalDateTime timestamp = LocalDateTime.now();
}

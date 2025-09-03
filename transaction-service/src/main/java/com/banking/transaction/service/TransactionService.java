// TransactionService.java
package com.banking.transaction.service;

import com.banking.transaction.model.Transaction;
import com.banking.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository repository;
    private final KafkaTemplate<String, Transaction> kafkaTemplate;
    private final String topic = "transactions";

    public Transaction createTransaction(Transaction tx) {
        Transaction saved = repository.save(tx);
        kafkaTemplate.send(topic, saved); // Publish to Kafka
        return saved;
    }

    public List<Transaction> getAll() { return repository.findAll(); }
}

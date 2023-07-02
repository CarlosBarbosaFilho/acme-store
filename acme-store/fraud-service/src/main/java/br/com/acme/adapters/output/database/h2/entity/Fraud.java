package br.com.acme.adapters.output.database.h2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Fraud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String document;
    private boolean active;
    private LocalDateTime create_at;
    private LocalDateTime update_at;
}

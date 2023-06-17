package br.com.acme.adapters.output.database.h2.repository;

import br.com.acme.adapters.output.database.h2.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}

package br.com.acme.adapters.output.database.h2.repository;

import br.com.acme.adapters.output.database.h2.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository <Card, Long> {

    List<Card> findByIncomeLessThanEqual(BigDecimal income);
}

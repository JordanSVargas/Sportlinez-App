package com.sportlines.Sportlinez.repository;

import com.sportlines.Sportlinez.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BetRepository extends JpaRepository<Bet, Long> {
    Optional<Bet> findAllByAccountId(Long accountId);
}

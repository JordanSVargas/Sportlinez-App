package com.sportlines.Sportlinez.controller;

import com.sportlines.Sportlinez.model.Bet;
import com.sportlines.Sportlinez.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/bets")
public class BetController {

    @Autowired
    private BetService betService;

    @GetMapping
    public ResponseEntity<Iterable<Bet>> getAllBets() {
        Iterable<Bet> bets = betService.getAllBets();
        return ResponseEntity.ok(bets);
    }

    @GetMapping("/{betId}")
    public ResponseEntity<Bet> getBetById(@PathVariable Long betId) {
        Optional<Bet> bet = betService.getAllBetsById(betId);
        return bet.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<Optional<Bet>> getBetsByAccountId(@PathVariable Long accountId) {
        Optional<Bet> bets = betService.getAllBetsFromAccountId(accountId);
        return ResponseEntity.ok(bets);
    }

    @PostMapping("/accounts/{accountId}")
    public ResponseEntity<Bet> createBet(@RequestBody Bet bet, @PathVariable Long accountId) {
        Bet createdBet = betService.createBet(bet, accountId);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdBet.getId()).toUri());
        return new ResponseEntity<>(createdBet, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{betId}")
    public ResponseEntity<Void> updateBet(@RequestBody Bet bet, @PathVariable Long betId) {
        betService.updateBet(bet, betId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{betId}")
    public ResponseEntity<Void> deleteBet(@PathVariable Long betId) {
        betService.deleteBetById(betId);
        return ResponseEntity.noContent().build();
    }
}
package com.sportlines.Sportlinez.controller;

import com.sportlines.Sportlinez.model.Parlay;
import com.sportlines.Sportlinez.service.ParlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;
@RestController
@RequestMapping("/parlays")
public class ParlayController {

    @Autowired
    private ParlayService parlayService;

    @GetMapping
    public ResponseEntity<Iterable<Parlay>> getAllParlays() {
        Iterable<Parlay> parlays = parlayService.getAllParlays();
        return ResponseEntity.ok(parlays);
    }

    @GetMapping("/{parlayId}")
    public ResponseEntity<Parlay> getParlayById(@PathVariable Long parlayId) {
        Optional<Parlay> parlay = parlayService.getParlayById(parlayId);
        return parlay.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Parlay> createParlay(@RequestBody Parlay parlay) {
        Parlay createdParlay = parlayService.createParlay(parlay);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdParlay.getId()).toUri());
        return new ResponseEntity<>(createdParlay, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{parlayId}")
    public ResponseEntity<Void> updateParlay(@PathVariable Long parlayId, @RequestBody Parlay parlay) {
        parlayService.updateParlay(parlayId, parlay);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{parlayId}")
    public ResponseEntity<Void> deleteParlay(@PathVariable Long parlayId) {
        parlayService.deleteParlayById(parlayId);
        return ResponseEntity.noContent().build();
    }
}
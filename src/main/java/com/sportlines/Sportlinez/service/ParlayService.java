package com.sportlines.Sportlinez.service;

import com.sportlines.Sportlinez.model.Parlay;
import com.sportlines.Sportlinez.repository.ParlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class ParlayService {

    @Autowired
    private ParlayRepository parlayRepository;

    public Iterable<Parlay> getAllParlays() {
        return parlayRepository.findAll();
    }

    public Optional<Parlay> getParlayById(Long parlayId) {
        return parlayRepository.findById(parlayId);
    }

    public Parlay createParlay(Parlay parlay) {
        return parlayRepository.save(parlay);
    }

    public Optional<Parlay> updateParlay(Long parlayId, Parlay parlay) {
        Parlay originalParlay = parlayRepository.findById(parlayId).orElse(null);
        if (originalParlay != null) {
            originalParlay.setBets(parlay.getBets());
            // Set other fields as needed
            return Optional.of(parlayRepository.save(originalParlay));
        }
        return Optional.empty();
    }

    public void deleteParlayById(Long parlayId) {
        parlayRepository.deleteById(parlayId);
    }
}

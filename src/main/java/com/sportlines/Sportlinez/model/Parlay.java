package com.sportlines.Sportlinez.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Parlay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parlay_id")
    private Long id;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "parlay_bet",
            joinColumns = @JoinColumn(name = "parlay_id"),
            inverseJoinColumns = @JoinColumn(name = "bet_id")
    )
    private Set<Bet> bets;

    public Set<Bet> getBets() {
        return bets;
    }

    public void setBets(Set<Bet> bets) {
        this.bets = bets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
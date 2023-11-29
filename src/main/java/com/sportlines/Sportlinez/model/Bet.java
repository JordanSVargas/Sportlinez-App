package com.sportlines.Sportlinez.model;


import jakarta.persistence.*;

@Entity
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bet_id")
    private Long id;
    private String sportName;
    private String teamName;
    private String playerName;
    private String betType;
    private Double amount;
    private Double odds;
    @ManyToOne // or OneToOne, depending on your relationship
    @JoinColumn(name = "account_id")
    private Account account;

    private Bet(){

    }

    public Bet(Account account) {

    }

    public Bet(Long id, String sportName, String teamName, String playerName, String betType, Double amount, Double odds, Account account) {
        this.id = id;
        this.sportName = sportName;
        this.teamName = teamName;
        this.playerName = playerName;
        this.betType = betType;
        this.amount = amount;
        this.odds = odds;
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getBetType() {
        return betType;
    }

    public void setBetType(String betType) {
        this.betType = betType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getOdds() {
        return odds;
    }

    public void setOdds(Double odds) {
        this.odds = odds;
    }
    @Override
    public String toString() {
        return "Bet{" +
                "id=" + id +
                ", sportName='" + sportName + '\'' +
                ", teamName='" + teamName + '\'' +
                ", playerName='" + playerName + '\'' +
                ", betType='" + betType + '\'' +
                ", amount=" + amount +
                ", odds=" + odds +
                '}';
    }
}

package com.sportlines.Sportlinez.service;

import com.sportlines.Sportlinez.model.Account;
import com.sportlines.Sportlinez.model.Bet;
import com.sportlines.Sportlinez.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BetService {
    @Autowired
    private BetRepository betRepository;
    public Iterable<Bet> getAllBets(){
        return betRepository.findAll();
    }
    public Optional<Bet> getAllBetsById(Long id){
        return betRepository.findById(id);
    }
    public Optional<Bet> getAllBetsFromAccountId(Long accountId){
        return betRepository.findAllByAccountId(accountId);
    }
    public Bet createBet(Bet bet, Long id){
        return betRepository.save(bet);
    }
    public void updateBet(Bet bet, Long id){

        Bet originalBet = betRepository.findById(id).get();
        originalBet.setBetType(bet.getBetType());
        originalBet.setAmount(bet.getAmount());
        originalBet.setOdds(bet.getOdds());
        originalBet.setSportName(bet.getSportName());
        originalBet.setPlayerName(bet.getPlayerName());
        originalBet.setTeamName(bet.getTeamName());
        betRepository.save(originalBet);
    }
    public void deleteBetById(Long id){
        betRepository.deleteById(id);
    }
}

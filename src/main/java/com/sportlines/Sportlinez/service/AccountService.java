package com.sportlines.Sportlinez.service;

import com.sportlines.Sportlinez.model.Account;
import com.sportlines.Sportlinez.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
    public Optional<Account> getAccountById(Long accountId){
        return accountRepository.findById(accountId);
    }
    public List<Account> getAccountByUserId( Long userId){
        return accountRepository.findByUserId(userId);
    }
    public Account createAccount( Account account, Long userId){
        return accountRepository.save(account);
    }
    public Optional<Account> updateAccount(Long accountId, Account account){
        Account originalAccount = accountRepository.findById(accountId).get();
        originalAccount.setBalance(account.getBalance());
        originalAccount.setUser(account.getUser());
        originalAccount.setNickName(account.getNickName());
        return Optional.of(accountRepository.save(originalAccount));
    }

    public void deleteAccountById(Long accountId){
        accountRepository.deleteById(accountId);
    }
}



package com.abhi.assignment3.service;

import com.abhi.assignment3.save.entity.Account;
import com.abhi.assignment3.dto.AccountDTO;
import com.abhi.assignment3.exception.AppAccountNotFoundException;
import com.abhi.assignment3.mapper.AccountEnrichmentMapper;
import com.abhi.assignment3.repository.AccountEnrichmentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class AccountEnrichmentServiceImpl implements AccountEnrichmentService {
    @Autowired
    private AccountEnrichmentRepo accountsRepo;
    @Autowired
    private AccountEnrichmentMapper accountEnrichmentMapper;


    @Override
    public Account add(Account addAccount) {
        Account newAc = accountsRepo.save(addAccount);
        return newAc;

    }

    public AccountDTO getByAccountId(String accountID) throws AppAccountNotFoundException {
        Optional<Account> accountOptional = accountsRepo.findByAccountId(accountID);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            AccountDTO accountDTO = accountEnrichmentMapper.convertAccountEntityToAccountDTO(account);
            return accountDTO;
        } else {
            throw new AppAccountNotFoundException("Missing account. AC : " + accountID);
        }
    }
}

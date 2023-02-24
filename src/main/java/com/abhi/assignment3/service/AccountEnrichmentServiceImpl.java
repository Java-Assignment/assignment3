package com.abhi.assignment3.service;

import com.abhi.assignment3.entity.AccountResponse;
import com.abhi.assignment3.entity.AddAccountEnrichment;
import com.abhi.assignment3.mapper.AccountEnrichmentMapper;
import com.abhi.assignment3.repository.AccountEnrichmentRepo;
import com.abhi.assignment3.entity.AccountEnrichment;
import com.abhi.assignment3.exception.AppAccountNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;


@Service
@Slf4j
public class AccountEnrichmentServiceImpl implements AccountEnrichmentService {
    @Autowired
    private AccountEnrichmentRepo accountsRepo;
    @Autowired
    private AccountEnrichmentMapper accountEnrichmentMapper;



    @Override
    public AccountEnrichment add(AddAccountEnrichment addAccountEnrichment) {
        AccountEnrichment accountEnrichment=accountEnrichmentMapper.convertAddAcToAe(addAccountEnrichment);
        accountEnrichment.setCreateDate(LocalDate.now());
        AccountEnrichment newAc=accountsRepo.save(accountEnrichment);
        return  newAc;

    }

    public AccountResponse  getByAccountID(String accountID) throws AppAccountNotFoundException {
        Optional<AccountEnrichment> db = accountsRepo.findByAccountID(accountID);
        if (db.isPresent()) {
            AccountEnrichment account=accountsRepo.findById(accountID).get();
            AccountResponse ar=accountEnrichmentMapper.convertAcToAr(account);
            return  ar;

        }
        else{
            throw new AppAccountNotFoundException("Missing account. AC : "+accountID);
        }
    }
}

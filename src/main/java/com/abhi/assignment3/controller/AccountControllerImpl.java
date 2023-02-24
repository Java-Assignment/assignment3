package com.abhi.assignment3.controller;

import com.abhi.assignment3.entity.AccountEnrichment;
import com.abhi.assignment3.exception.AppAccountNotFoundException;
import com.abhi.assignment3.service.AccountEnrichmentService;
import com.abhi.assignment3.service.AccountEnrichmentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AccountControllerImpl implements  AccountController{
    @Autowired
    private AccountEnrichmentServiceImpl accountEnrichment;


    @Override
    public ResponseEntity<AccountEnrichment> getAccountEnrichment(String accountID) throws AppAccountNotFoundException {
        AccountEnrichment acc=  accountEnrichment.getByAccountID(accountID);
        return new ResponseEntity<>(acc, HttpStatus.OK);
    }
}

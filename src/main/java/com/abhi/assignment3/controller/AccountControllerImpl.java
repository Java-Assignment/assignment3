package com.abhi.assignment3.controller;

import com.abhi.assignment3.dto.AccountDTO;
import com.abhi.assignment3.exception.AppAccountNotFoundException;
import com.abhi.assignment3.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AccountControllerImpl implements AccountController {

    @Autowired
    private AccountService accountService;


    @Override
    public ResponseEntity<AccountDTO> getAccount(String accountId) throws AppAccountNotFoundException {
        AccountDTO accountDTO = accountService.getByAccountId(accountId);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }
}

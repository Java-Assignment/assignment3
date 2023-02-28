package com.abhi.assignment3.service;

import com.abhi.assignment3.dto.AccountDTO;
import com.abhi.assignment3.exception.AppAccountNotFoundException;
import com.abhi.assignment3.save.entity.Account;

public interface AccountEnrichmentService {

    Account add(Account addAccount);

    AccountDTO getByAccountId(String accountID) throws AppAccountNotFoundException;
}

package com.abhi.assignment3.service;

import com.abhi.assignment3.entity.AccountEnrichment;
import com.abhi.assignment3.entity.AccountResponse;
import com.abhi.assignment3.entity.AddAccountEnrichment;
import com.abhi.assignment3.exception.AppAccountNotFoundException;

public interface AccountEnrichmentService {
    AccountEnrichment add(AddAccountEnrichment addAccountEnrichment);

    AccountResponse getByAccountID(String accountID) throws AppAccountNotFoundException;
}

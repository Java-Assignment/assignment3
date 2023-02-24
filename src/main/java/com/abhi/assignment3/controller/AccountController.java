package com.abhi.assignment3.controller;


import com.abhi.assignment3.entity.AccountEnrichment;
import com.abhi.assignment3.entity.AccountResponse;
import com.abhi.assignment3.exception.AppAccountNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/customeraccounts", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
@Tag(name = "customer accounts api", description = "api operations for customer account")
public interface AccountController {
    @GetMapping("/{accountID}")
    @Operation(summary = "get account details based on account id")
    ResponseEntity<AccountResponse> getAccountEnrichment(@PathVariable(value = "accountID") String accountID) throws AppAccountNotFoundException;

}

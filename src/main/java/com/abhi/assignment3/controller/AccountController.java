package com.abhi.assignment3.controller;


import com.abhi.assignment3.dto.AccountDTO;
import com.abhi.assignment3.exception.AppAccountNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/accounts", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
@Tag(name = "accounts api", description = "api operations for account")
public interface AccountController {
    @GetMapping("/{accountId}")
    @Operation(summary = "get account details based on account id")
    ResponseEntity<AccountDTO> getAccount(@PathVariable(value = "accountId") String accountId) throws AppAccountNotFoundException;

}

package com.abhi.assignment3;


import com.abhi.assignment3.common.AccountStatus;
import com.abhi.assignment3.common.AccountType;
import com.abhi.assignment3.dto.AccountDTO;
import com.abhi.assignment3.repository.AccountRepo;
import com.abhi.assignment3.save.entity.Account;
import com.abhi.assignment3.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class TestAccount {
    @Autowired
    AccountRepo accountRepo;

    private ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;

    private Account testAddAc;
    private Account testAddAc1;
    private Account testAddAc2;
    @Autowired
    AccountService accountService;


    @BeforeEach
    void setup() {
        testAddAc = new Account();
        testAddAc.setAccountId("000000000001");
        testAddAc.setAccountStatus(AccountStatus.ACTIVE);
        testAddAc.setAccountType(AccountType.HNI);
        testAddAc.setCreateDate(LocalDate.now());
        testAddAc1 = new Account();
        testAddAc1.setAccountId("000000000002");
        testAddAc1.setAccountStatus(AccountStatus.ACTIVE);
        testAddAc1.setAccountType(AccountType.WEALTH);
        testAddAc1.setCreateDate(LocalDate.now());
        testAddAc2 = new Account();
        testAddAc2.setAccountId("000000000003");
        testAddAc2.setAccountStatus(AccountStatus.INACTIVE);
        testAddAc2.setAccountType(AccountType.NORMAL);
        testAddAc2.setCreateDate(LocalDate.now());


        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

    }

    @Test
    @DisplayName("Add account Test ")
    void testAccount() throws Exception {
        Account dbac = accountService.add(testAddAc);
        accountService.add(testAddAc1);
        accountService.add(testAddAc2);
        String accId = dbac.getAccountId();

        MvcResult mvcResult = mockMvc.perform(
                        get("/accounts" + "/" + accId)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE)


                )
                .andDo(print())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        AccountDTO accountDTO = objectMapper.readValue(contentAsString, AccountDTO.class);


        Assertions.assertAll(
                () -> Assertions.assertEquals(testAddAc.getAccountStatus(), accountDTO.getAccountStatus())

        );

    }


}

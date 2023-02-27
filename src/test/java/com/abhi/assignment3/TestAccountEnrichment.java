package com.abhi.assignment3;


import com.abhi.assignment3.entity.*;
import com.abhi.assignment3.repository.AccountEnrichmentRepo;
import com.abhi.assignment3.service.AccountEnrichmentService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class TestAccountEnrichment {
    @Autowired
    AccountEnrichmentRepo accountEnrichmentRepo;

    private ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;

    private AddAccountEnrichment testAddAc;
    private AddAccountEnrichment testAddAc1;
    private AddAccountEnrichment testAddAc2;
    @Autowired
    AccountEnrichmentService accountEnrichmentService;


    @BeforeEach
    void setup() {
        testAddAc = new AddAccountEnrichment();
        testAddAc.setAccountID("000000000001");
        testAddAc.setAccountStatus(AccountStatus.ACTIVE);
        testAddAc.setAccountType(AccountType.HNI);
        testAddAc1 = new AddAccountEnrichment();
        testAddAc1.setAccountID("000000000002");
        testAddAc1.setAccountStatus(AccountStatus.ACTIVE);
        testAddAc1.setAccountType(AccountType.WEALTH);
        testAddAc2 = new AddAccountEnrichment();
        testAddAc2.setAccountID("000000000003");
        testAddAc2.setAccountStatus(AccountStatus.INACTIVE);
        testAddAc2.setAccountType(AccountType.NORMAL);


        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

    }

    @Test
    @DisplayName("Add account Test ")
    void testAddAccount() throws Exception {
        AccountEnrichment dbac = accountEnrichmentService.add(testAddAc);
        accountEnrichmentService.add(testAddAc1);
        accountEnrichmentService.add(testAddAc2);
        String accId = dbac.getAccountID();

        MvcResult mvcResult = mockMvc.perform(
                        get("/customeraccounts" + "/" + accId)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE)


                )
                .andDo(print())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        AccountResponse accountResponse = objectMapper.readValue(contentAsString, AccountResponse.class);


        Assertions.assertAll(
                () -> Assertions.assertEquals(testAddAc.getAccountStatus(), accountResponse.getAccountStatus())

        );

    }


}

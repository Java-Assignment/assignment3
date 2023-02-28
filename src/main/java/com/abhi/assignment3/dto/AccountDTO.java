package com.abhi.assignment3.dto;

import com.abhi.assignment3.common.AccountStatus;
import com.abhi.assignment3.common.AccountType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor

public class AccountDTO {
    private String accountId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate createDate;

    private AccountType accountType;
    private AccountStatus accountStatus;

}

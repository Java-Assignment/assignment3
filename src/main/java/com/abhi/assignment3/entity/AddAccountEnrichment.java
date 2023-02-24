package com.abhi.assignment3.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Schema(description = "This is the expected response for the user")

public class AddAccountEnrichment {
    @NotNull
    @Id
    private String accountID;
    @NotNull
    private AccountType accountType;
    @NotNull
    private AccountStatus accountStatus;
}

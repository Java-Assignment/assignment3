package com.abhi.assignment3.mapper;

import com.abhi.assignment3.dto.AccountDTO;
import com.abhi.assignment3.save.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {


    AccountDTO convertAccountEntityToAccountDTO(Account account);
}
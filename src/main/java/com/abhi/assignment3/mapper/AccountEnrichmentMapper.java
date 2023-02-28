package com.abhi.assignment3.mapper;

import com.abhi.assignment3.save.entity.Account;
import com.abhi.assignment3.dto.AccountDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountEnrichmentMapper {


    AccountDTO convertAccountEntityToAccountDTO(Account account);
}

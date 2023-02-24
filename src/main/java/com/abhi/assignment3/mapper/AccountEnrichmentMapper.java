package com.abhi.assignment3.mapper;

import com.abhi.assignment3.entity.AccountEnrichment;
import com.abhi.assignment3.entity.AddAccountEnrichment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountEnrichmentMapper {

    AccountEnrichment convertAddAcToAe(AddAccountEnrichment addAccountEnrichment);
}

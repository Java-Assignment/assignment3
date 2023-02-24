package com.abhi.assignment3.repository;

import com.abhi.assignment3.entity.AccountEnrichment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountEnrichmentRepo extends MongoRepository<AccountEnrichment,String> {

    Optional<AccountEnrichment> findByAccountID(String accountID);
}

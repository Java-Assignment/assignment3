package com.abhi.assignment3.repository;

import com.abhi.assignment3.save.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountEnrichmentRepo extends MongoRepository<Account, String> {

    Optional<Account> findByAccountId(String accountId);
}

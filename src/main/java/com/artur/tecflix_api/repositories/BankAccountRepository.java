package com.artur.tecflix_api.repositories;

import com.artur.tecflix_api.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankAccountRepository extends JpaRepository<BankAccount, UUID> {
}

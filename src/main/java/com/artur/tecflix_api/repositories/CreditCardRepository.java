package com.artur.tecflix_api.repositories;

import com.artur.tecflix_api.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreditCardRepository extends JpaRepository<CreditCard, UUID> {
}

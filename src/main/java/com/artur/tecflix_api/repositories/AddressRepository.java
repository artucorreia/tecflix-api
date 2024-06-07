package com.artur.tecflix_api.repositories;

import com.artur.tecflix_api.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}

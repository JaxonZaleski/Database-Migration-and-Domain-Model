 package com.zaleskjn.mydb.repositories;

import com.zaleskjn.mydb.entities.Addresses;
import org.springframework.data.repository.CrudRepository;

public interface AddressesRepository extends CrudRepository<Addresses, Long> {
}
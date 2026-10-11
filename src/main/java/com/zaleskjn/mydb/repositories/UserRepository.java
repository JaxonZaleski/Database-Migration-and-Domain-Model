package com.zaleskjn.mydb.repositories;

import com.zaleskjn.mydb.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

package com.zaleskjn.mydb.repositories;

import com.zaleskjn.mydb.entities.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilesRepository extends JpaRepository<Profiles, Long> {
}
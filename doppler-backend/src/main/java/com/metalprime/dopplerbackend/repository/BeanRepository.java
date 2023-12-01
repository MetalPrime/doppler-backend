package com.metalprime.dopplerbackend.repository;

import com.metalprime.dopplerbackend.model.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeanRepository extends JpaRepository<Bean,Integer> {
}

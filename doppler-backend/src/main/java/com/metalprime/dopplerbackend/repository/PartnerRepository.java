package com.metalprime.dopplerbackend.repository;

import com.metalprime.dopplerbackend.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner,Integer> {
}

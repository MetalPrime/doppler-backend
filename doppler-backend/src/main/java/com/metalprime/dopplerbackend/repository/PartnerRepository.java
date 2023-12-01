package com.metalprime.dopplerbackend.repository;

import com.metalprime.dopplerbackend.model.Partner;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerRepository extends JpaRepository<Partner,Integer> {
    @Query("SELECT p FROM Partner p WHERE (:query IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :query, '%'))) ORDER BY p.id DESC")
    List<Partner> findFilteredPartners(Pageable pageable, @Param("query") String query);

    @Query("SELECT COUNT(p) FROM Partner p WHERE (:query IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :query, '%')))")
    Integer getPartnersPages(@Param("query") String query);
}

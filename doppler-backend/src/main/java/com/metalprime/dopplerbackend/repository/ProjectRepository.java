package com.metalprime.dopplerbackend.repository;

import com.metalprime.dopplerbackend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {

    @Query("SELECT p FROM Project p WHERE (:query IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :query, '%'))) ORDER BY p.id DESC")
    List<Project> findFilteredProjects(Pageable pageable, @Param("query") String query);

    @Query("SELECT COUNT(p) FROM Project p WHERE (:query IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :query, '%')))")
    Integer getProjectsPages(@Param("query") String query);
}

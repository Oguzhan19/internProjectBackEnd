package com.polarcape.intern.interproject.repository;

import com.polarcape.intern.interproject.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Project p WHERE p.id = :projectId")
    public void deleteByProjectId(@Param("projectId") Long id);

    @Query("Select p FROM Project p WHERE p.id = :projectId")
    public Project findByProjectId(@Param("projectId") Long id);
}

package com.polarcape.intern.interproject.repository;

import com.polarcape.intern.interproject.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    @Transactional
    @Modifying
    @Query("DELETE From Assignment a WHERE a.id = :assignmentId")
    public void deleteByAssignmentId(@Param("assignmentId") Long id);

    @Query("Select a FROM Assignment a WHERE a.id = :assignmentId")
    public Assignment findByassignmentId(@Param("assignmentId") Long id);
}

package com.polarcape.intern.interproject.repository;

import com.polarcape.intern.interproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Employee e WHERE e.empID = :employeeId")
    public void deleteByEmployeeId(@Param("employeeId") Long id);

    @Query("Select e FROM Employee e WHERE e.empID = :employeeId")
    public Employee findByEmployeeId(@Param("employeeId") Long id);
}

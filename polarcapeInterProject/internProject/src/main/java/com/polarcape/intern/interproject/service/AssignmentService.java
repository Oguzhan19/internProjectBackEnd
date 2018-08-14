package com.polarcape.intern.interproject.service;

import java.util.List;

import com.polarcape.intern.interproject.model.Assignment;

public interface AssignmentService {

    public void addAssignment(Assignment assignment);

    public List<Assignment> getAllAssignments();

    public void deleteAssignment(Long id);

    public Assignment getAssignment(Long id);

    public void updateAssignment(Assignment assignment);
}

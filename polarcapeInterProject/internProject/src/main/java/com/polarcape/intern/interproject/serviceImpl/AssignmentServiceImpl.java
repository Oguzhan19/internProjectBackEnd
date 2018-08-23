package com.polarcape.intern.interproject.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.polarcape.intern.interproject.model.Assignment;
import com.polarcape.intern.interproject.repository.AssignmentRepository;
import com.polarcape.intern.interproject.service.AssignmentService;

@Service
@Transactional
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public Assignment addAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Override
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    @Override
    public void deleteAssignment(Long empID) {
        assignmentRepository.deleteByAssignmentId(empID);
    }

    @Override
    public Assignment getAssignment(Long empID) {
        return assignmentRepository.findByassignmentId(empID);
    }

    @Override
    public Assignment updateAssignment(Assignment assignment) {
       return assignmentRepository.save(assignment);
    }

}

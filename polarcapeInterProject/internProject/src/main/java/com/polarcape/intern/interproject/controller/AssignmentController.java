package com.polarcape.intern.interproject.controller;

import com.polarcape.intern.interproject.model.Assignment;
import com.polarcape.intern.interproject.repository.AssignmentRepository;
import com.polarcape.intern.interproject.service.AssignmentService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;
    @Autowired
    private AssignmentRepository assignmentRepository;

    @RequestMapping(value = "/assignment", method = RequestMethod.GET, produces = "application/json")
    public List<Assignment> listAssignment() {
        return assignmentService.getAllAssignments();
    }

    @RequestMapping(value = "/newAssignment", method = RequestMethod.POST)
    public Assignment addAssignment(@RequestBody Assignment assignment) {
        return assignmentService.addAssignment(assignment);
    }

    @RequestMapping(value = "/deleteAssignment", method = RequestMethod.DELETE)
    public void deleteAssignment(HttpServletRequest request) {
        Long assignmentID = Long.parseLong(request.getParameter("id"));
        assignmentService.deleteAssignment(assignmentID);
    }

    @RequestMapping(value = "/getAssignment", method = RequestMethod.GET)
    public Assignment getAssignment(@RequestParam("id") Long id) {
        //Long employeeId = Long.parseLong(request.getParameter("empID"));
        return assignmentService.getAssignment(id);
    }

    @RequestMapping(value = "/updateAssignment", method = RequestMethod.PUT)
    public Assignment updateAssignment(Assignment assignment) {

      
        return assignmentRepository.save(assignment);

    }

}

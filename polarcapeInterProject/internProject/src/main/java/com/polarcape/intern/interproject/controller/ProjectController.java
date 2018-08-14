package com.polarcape.intern.interproject.controller;

import com.polarcape.intern.interproject.model.Project;
import com.polarcape.intern.interproject.repository.ProjectRepository;
import com.polarcape.intern.interproject.service.ProjectService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;
 
    @Autowired
    private ProjectRepository projectRepository;
    
    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public List <Project> listProject(ModelAndView model) throws IOException
    {
        return projectService.getAllProjects();
    }
    
      @RequestMapping(value = "/getProject", method = RequestMethod.GET)
    public Project getProject(@RequestParam("id") Long id) {
        return projectService.getProject(id);
        
    }
 
    @RequestMapping(value = "/newProject", method = RequestMethod.POST)
    public void addProject(@RequestBody Project project) {
        projectService.addProject(project);
    }
 

 
    @RequestMapping(value = "/deleteProject", method = RequestMethod.DELETE)
    public void deleteProject(HttpServletRequest request) {
        Long projectId = Long.parseLong(request.getParameter("id"));
        projectService.deleteProject(projectId);
    }
    
    
    @RequestMapping(value = "/updateProject", method = RequestMethod.PUT)
    public void updateProject(@RequestParam("id") Long id) {
            Project project;
            project= projectService.getProject(id);
            project.setPname("atkafasi");
            projectRepository.save(project);
        
    }
}

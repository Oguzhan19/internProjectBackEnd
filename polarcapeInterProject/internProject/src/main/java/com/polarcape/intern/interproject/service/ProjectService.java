package com.polarcape.intern.interproject.service;

import java.util.List;
import com.polarcape.intern.interproject.model.Project;

public interface ProjectService {

    public void addProject(Project project);

    public List<Project> getAllProjects();

    public void deleteProject(Long id);

    public Project getProject(Long id);

    public void updateProject(Project project);

}

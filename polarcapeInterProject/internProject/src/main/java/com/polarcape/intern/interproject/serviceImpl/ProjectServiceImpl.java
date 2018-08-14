package com.polarcape.intern.interproject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.polarcape.intern.interproject.model.Project;
import com.polarcape.intern.interproject.repository.ProjectRepository;
import com.polarcape.intern.interproject.service.ProjectService;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void addProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }


    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteByProjectId(id);
    }

    @Override
    public Project getProject(Long id) {
        return projectRepository.findByProjectId(id);
    }

    @Override
    public void updateProject(Project project) {
        projectRepository.save(project);
    }

}

package com.karacadaglii.issuemanagement.Entity.service.impl;

import com.karacadaglii.issuemanagement.Entity.Entity.Project;
import com.karacadaglii.issuemanagement.Entity.repository.ProjectRepository;
import com.karacadaglii.issuemanagement.Entity.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service // Singlrton bi instabce yaratır.
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    public ProjectServiceImpl(ProjectRepository projectRepository){

        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {
        if (project.getProjectCode() == null) {
            throw new IllegalArgumentException("Project code can not be null");
        }
        return projectRepository.save(project);
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return projectRepository.getAllByProjectCode(projectCode);
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode, String name) {
        return projectRepository.getAllByProjectCodeAndProjectNameContains(projectCode, name);
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {
        projectRepository.delete(project);
        return Boolean.TRUE;
    }
}

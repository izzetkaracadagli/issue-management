package com.karacadaglii.issuemanagement.Entity.service.impl;

import com.karacadaglii.issuemanagement.Entity.Entity.Project;
import com.karacadaglii.issuemanagement.Entity.dto.ProjectDto;
import com.karacadaglii.issuemanagement.Entity.repository.ProjectRepository;
import com.karacadaglii.issuemanagement.Entity.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service // Singlrton bi instabce yaratır.
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper){

        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {

        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
        if(projectCheck == null)
            throw new IllegalArgumentException("Project Code cannot be null");
        Project p = modelMapper.map(project, Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p,ProjectDto.class);
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
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

    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {
        Project projectDb = projectRepository.getOne(id);
        if(projectDb == null)
            throw new IllegalArgumentException("Project does not exist" + id);

        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(),id);
        if(projectCheck != null)
            throw new IllegalArgumentException("Project Code cannot be null");
        projectDb.setProjectCode(project.getProjectCode());
        projectDb.setProjectName(project.getProjectName());
        projectRepository.save(projectDb);
        return modelMapper.map(projectDb, ProjectDto.class);
    }
}

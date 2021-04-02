package com.karacadaglii.issuemanagement.Entity.service;

import com.karacadaglii.issuemanagement.Entity.Entity.Project;
import com.karacadaglii.issuemanagement.Entity.dto.ProjectDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    ProjectDto getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode, String name);

    Page<Project> getAllPageable(Pageable pageable);

    Boolean delete(Project project);

    ProjectDto update(Long id, ProjectDto projectDto);
}

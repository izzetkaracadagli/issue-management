package com.karacadaglii.issuemanagement.Entity.service;

import com.karacadaglii.issuemanagement.Entity.Entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    Project getById(Long id);

    List<Project> getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode, String name);

    Page<Project> getAllPageable(Pageable pageable);

    Boolean delete(Project project);
}
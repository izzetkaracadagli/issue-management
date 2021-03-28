package com.karacadaglii.issuemanagement.Entity.repository;

import com.karacadaglii.issuemanagement.Entity.Entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> getAllByProjectCode(String projectCode);

    Project getByProjectCodeAndIdNot(String projectCode, Long id);

    List<Project> getAllByProjectCodeAndProjectNameContains(String projectCode, String name);

    Page<Project> findAll(Pageable pageable); //Tablolarda sayfalama yapar

    List<Project> findAll(Sort sort);
}

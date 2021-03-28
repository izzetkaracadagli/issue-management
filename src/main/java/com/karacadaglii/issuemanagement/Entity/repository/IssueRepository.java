package com.karacadaglii.issuemanagement.Entity.repository;

import com.karacadaglii.issuemanagement.Entity.Entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {

}

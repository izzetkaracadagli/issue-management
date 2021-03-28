package com.karacadaglii.issuemanagement.Entity.repository;

import com.karacadaglii.issuemanagement.Entity.Entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {
    List<IssueHistory> getByIssueIdOrderById(Long id);
}

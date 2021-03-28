package com.karacadaglii.issuemanagement.Entity.service;

import com.karacadaglii.issuemanagement.Entity.Entity.Issue;
import com.karacadaglii.issuemanagement.Entity.Util.TPage;
import com.karacadaglii.issuemanagement.Entity.dto.IssueDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueDto issue);
}

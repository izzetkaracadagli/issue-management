package com.karacadaglii.issuemanagement.Entity.service.impl;

import com.karacadaglii.issuemanagement.Entity.Entity.Issue;
import com.karacadaglii.issuemanagement.Entity.Util.TPage;
import com.karacadaglii.issuemanagement.Entity.dto.IssueDto;
import com.karacadaglii.issuemanagement.Entity.repository.IssueRepository;
import com.karacadaglii.issuemanagement.Entity.service.IssueService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;
    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public IssueDto save(IssueDto issue) {
        if(issue.getDate() == null){
            throw new IllegalArgumentException("Issue date can not be null.");
        }
        Issue issueDb = modelMapper.map(issue, Issue.class);
        issueDb = issueRepository.save(issueDb);
        return modelMapper.map(issueDb, IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        Issue issue = issueRepository.getOne(id);
        IssueDto issueDto = modelMapper.map(issue, IssueDto.class);
        return issueDto;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage page = new TPage<IssueDto>();
        IssueDto[] dto = modelMapper.map(data.getContent(), IssueDto[].class);
        page.setStat(data,Arrays.asList(dto));
        return page;
    }

    @Override
    public Boolean delete(Long issueId) {
        issueRepository.deleteById(issueId);
        return true;
    }

    @Override
    public IssueDto update(Long id, IssueDto issueDto) {
        return null;
    }
}

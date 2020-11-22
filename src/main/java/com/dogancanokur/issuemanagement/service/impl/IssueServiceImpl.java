package com.dogancanokur.issuemanagement.service.impl;

import com.dogancanokur.issuemanagement.entity.Issue;
import com.dogancanokur.issuemanagement.model.input.IssueInput;
import com.dogancanokur.issuemanagement.model.output.IssueOutput;
import com.dogancanokur.issuemanagement.repository.IssueRepository;
import com.dogancanokur.issuemanagement.service.IssueService;
import com.dogancanokur.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {
    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueOutput save(IssueInput issueInput) {
        Issue issue = modelMapper.map(issueInput, Issue.class);
        return modelMapper.map(issueRepository.save(issue), IssueOutput.class);
    }

    @Override
    public IssueOutput getByID(Long id) {
        return modelMapper.map(issueRepository.getOne(id), IssueOutput.class);
    }

    @Override
    public TPage<IssueOutput> getAllPageable(Pageable pageable) {
        Page<Issue> issuePage = issueRepository.findAll(pageable);
        TPage<IssueOutput> page = new TPage<>();

        IssueOutput[] issueOutputs = modelMapper.map(issuePage.getContent(), IssueOutput[].class);
        page.setStats(issuePage, Arrays.asList(issueOutputs));
        return page;
    }

    @Override
    public Boolean deleteIssue(IssueInput issue) {
        return null;
    }
}

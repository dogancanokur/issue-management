package com.dogancanokur.issuemanagement.service.impl;

import com.dogancanokur.issuemanagement.entity.Issue;
import com.dogancanokur.issuemanagement.repository.IssueRepository;
import com.dogancanokur.issuemanagement.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueServiceImpl implements IssueService {
    private final IssueRepository issueRepository;

    @Autowired
    public IssueServiceImpl(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @Override
    public Issue save(Issue issue) {
        return issueRepository.save(issue);
    }

    @Override
    public Issue getByID(Long id) {
        return issueRepository.getOne(id);
    }

    @Override
    public Page<Issue> getAllPageable(Pageable pageable) {
        return issueRepository.findAll(pageable);
    }

    @Override
    public Boolean deleteIssue(Issue issue) {
        return null;
    }
}

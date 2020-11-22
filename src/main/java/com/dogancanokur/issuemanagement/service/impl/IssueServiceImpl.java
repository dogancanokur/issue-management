package com.dogancanokur.issuemanagement.service.impl;

import com.dogancanokur.issuemanagement.entity.Issue;
import com.dogancanokur.issuemanagement.model.input.IssueInput;
import com.dogancanokur.issuemanagement.model.output.IssueOutput;
import com.dogancanokur.issuemanagement.repository.IssueRepository;
import com.dogancanokur.issuemanagement.repository.UserRepository;
import com.dogancanokur.issuemanagement.service.IssueService;
import com.dogancanokur.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {
    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
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
    public Boolean deleteIssue(Long id) {
        try {
            issueRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<IssueOutput> getAll() {
        return Arrays.asList(modelMapper.map(issueRepository.findAll(), IssueOutput[].class));
    }

    @Override
    public IssueOutput update(Long id, IssueInput issueInput) {
        Issue issue;
        try {
            issue = issueRepository.getOne(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("issue not found");
        }
        issue.setAssignee(userRepository.getByUsername(issueInput.getAssignee().getUsername()));
        issue.setDescription(issueInput.getDescription());
        issue.setDetails(issueInput.getDetails());
        issue.setDate(issueInput.getDate());
        issue.setIssueStatus(issueInput.getIssueStatus());

        issueRepository.save(issue);
        return modelMapper.map(issue, IssueOutput.class);

    }
}

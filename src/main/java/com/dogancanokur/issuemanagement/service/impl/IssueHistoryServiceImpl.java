package com.dogancanokur.issuemanagement.service.impl;

import com.dogancanokur.issuemanagement.entity.IssueHistory;
import com.dogancanokur.issuemanagement.model.output.IssueHistoryOutput;
import com.dogancanokur.issuemanagement.repository.IssueHistoryRepository;
import com.dogancanokur.issuemanagement.service.IssueHistoryService;
import com.dogancanokur.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {
    private final IssueHistoryRepository issueHistoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository, ModelMapper modelMapper) {
        this.issueHistoryRepository = issueHistoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueHistory save(IssueHistory issueHistory) {
        if (issueHistory.getDate() == null) {
            throw new IllegalArgumentException("Issue History date cannot be null!");
        }
        return issueHistoryRepository.save(issueHistory);
    }

    @Override
    public IssueHistory getOne(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public TPage<IssueHistoryOutput> findAll(Pageable pageable) {
        Page<IssueHistory> issueHistories = issueHistoryRepository.findAll(pageable);
        TPage<IssueHistoryOutput> page = new TPage<>();

        IssueHistoryOutput[] issueHistoryOutputs = modelMapper.map(issueHistories.getContent(), IssueHistoryOutput[].class);
        page.setStats(issueHistories, Arrays.asList(issueHistoryOutputs));
        return page;
    }
}

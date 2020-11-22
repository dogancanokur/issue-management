package com.dogancanokur.issuemanagement.service.impl;

import com.dogancanokur.issuemanagement.entity.IssueHistory;
import com.dogancanokur.issuemanagement.repository.IssueHistoryRepository;
import com.dogancanokur.issuemanagement.service.IssueHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {
    private final IssueHistoryRepository issueHistoryRepository;

    @Autowired
    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository) {
        this.issueHistoryRepository = issueHistoryRepository;
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
    public Page<IssueHistory> findAll(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }
}

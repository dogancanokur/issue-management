package com.dogancanokur.issuemanagement.service;

import com.dogancanokur.issuemanagement.entity.IssueHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueHistoryService {
    IssueHistory save(IssueHistory issueHistory);

    IssueHistory getOne(Long id);

    Page<IssueHistory> findAll(Pageable pageable);
}

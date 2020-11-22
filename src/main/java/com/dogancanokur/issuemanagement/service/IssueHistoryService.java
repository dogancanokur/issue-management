package com.dogancanokur.issuemanagement.service;

import com.dogancanokur.issuemanagement.entity.IssueHistory;
import com.dogancanokur.issuemanagement.model.output.IssueHistoryOutput;
import com.dogancanokur.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

public interface IssueHistoryService {
    IssueHistory save(IssueHistory issueHistory);

    IssueHistory getOne(Long id);

    TPage<IssueHistoryOutput> findAll(Pageable pageable);
}

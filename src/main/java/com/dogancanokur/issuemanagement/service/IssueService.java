package com.dogancanokur.issuemanagement.service;

import com.dogancanokur.issuemanagement.entity.Issue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IssueService {
    Issue save(Issue issue);

    Issue getByID(Long id);

    Page<Issue> getAllPageable(Pageable pageable);

    Boolean deleteIssue(Issue issue);
}

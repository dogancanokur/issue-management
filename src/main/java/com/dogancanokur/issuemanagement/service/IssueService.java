package com.dogancanokur.issuemanagement.service;

import com.dogancanokur.issuemanagement.model.input.IssueInput;
import com.dogancanokur.issuemanagement.model.output.IssueOutput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IssueService {
    IssueOutput save(IssueInput issueInput);

    IssueOutput getByID(Long id);

    Page<IssueOutput> getAllPageable(Pageable pageable);

    Boolean deleteIssue(IssueInput issue);
}

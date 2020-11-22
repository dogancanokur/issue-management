package com.dogancanokur.issuemanagement.service;

import com.dogancanokur.issuemanagement.model.input.IssueInput;
import com.dogancanokur.issuemanagement.model.output.IssueOutput;
import com.dogancanokur.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;


public interface IssueService {
    IssueOutput save(IssueInput issueInput);

    IssueOutput getByID(Long id);

    TPage<IssueOutput> getAllPageable(Pageable pageable);

    Boolean deleteIssue(IssueInput issue);
}

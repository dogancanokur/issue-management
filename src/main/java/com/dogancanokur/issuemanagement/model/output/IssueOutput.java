package com.dogancanokur.issuemanagement.model.output;

import com.dogancanokur.issuemanagement.entity.IssueStatus;

import java.util.Date;

public class IssueOutput {

    private Long id;
    private String description;
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private UserOutput assignee;
}

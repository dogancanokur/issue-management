package com.dogancanokur.issuemanagement.model.input;

import com.dogancanokur.issuemanagement.entity.IssueStatus;
import com.dogancanokur.issuemanagement.model.output.UserOutput;
import lombok.Data;

import java.util.Date;

@Data
public class IssueInput {
    private Long id;
    private String description;
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private UserOutput assignee;
}

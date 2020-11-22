package com.dogancanokur.issuemanagement.model.output;

import com.dogancanokur.issuemanagement.entity.Issue;
import com.dogancanokur.issuemanagement.entity.User;

import java.util.Date;

public class IssueHistoryOutput {

    private Date date;
    private Issue issue;
    private User assignee;
}

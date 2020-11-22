package com.dogancanokur.issuemanagement.model.output;

import com.dogancanokur.issuemanagement.entity.Issue;
import com.dogancanokur.issuemanagement.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueHistoryOutput {

    private Date date;
    private Issue issue;
    private User assignee;
}

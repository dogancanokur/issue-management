package com.dogancanokur.issuemanagement.model.output;

import com.dogancanokur.issuemanagement.entity.Issue;
import com.dogancanokur.issuemanagement.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Issue History Output DTO")
public class IssueHistoryOutput {

    private Date date;
    private Issue issue;
    private User assignee;
}

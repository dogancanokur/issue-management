package com.dogancanokur.issuemanagement.model.output;

import com.dogancanokur.issuemanagement.entity.IssueStatus;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Issue Output DTO")
public class IssueOutput {

    private Long id;
    private String description;
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private UserOutput assignee;
    private ProjectOutput project;
}

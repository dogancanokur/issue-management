package com.dogancanokur.issuemanagement.model.input;

import com.dogancanokur.issuemanagement.entity.IssueStatus;
import com.dogancanokur.issuemanagement.model.output.UserOutput;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Issue Input DTO")
public class IssueInput {

    @ApiModelProperty(value = "ID of issue")
    private Long id;

    @NotNull
    @Size(max = 1000)
    @ApiModelProperty(value = "description of issue", required = true)
    private String description;

    @NotNull
    @Size(max = 4000)
    @ApiModelProperty(value = "details of issue", required = true)
    private String details;

    @ApiModelProperty(value = "date of issue")
    private Date date;

    @ApiModelProperty(value = "issue status of issue")
    private IssueStatus issueStatus;

    @ApiModelProperty(value = "details of issue")
    private UserOutput assignee;

    @ApiModelProperty(value = "project of issue")
    private ProjectInput project;
}

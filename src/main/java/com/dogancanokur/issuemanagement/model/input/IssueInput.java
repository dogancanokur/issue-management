package com.dogancanokur.issuemanagement.model.input;

import com.dogancanokur.issuemanagement.entity.IssueStatus;
import com.dogancanokur.issuemanagement.model.output.UserOutput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueInput {
    private Long id;
    @NotNull
    @Size(max = 1000)
    private String description;
    @NotNull
    @Size(max = 4000)
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private UserOutput assignee;
    private ProjectInput project;
}

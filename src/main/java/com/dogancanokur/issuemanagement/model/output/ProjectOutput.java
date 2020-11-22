package com.dogancanokur.issuemanagement.model.output;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Project Output DTO")
public class ProjectOutput {

    private Long id;

    @ApiModelProperty(value = "Name of project")
    private String projectCode;

    @ApiModelProperty(value = "Code of project")
    private String projectName;
}

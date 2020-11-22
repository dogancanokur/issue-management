package com.dogancanokur.issuemanagement.model.input;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Project Input DTO")
public class ProjectInput {
    private Long id;
    @NotNull
    private String projectCode;
    @NotNull
    private String projectName;
}

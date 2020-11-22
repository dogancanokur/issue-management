package com.dogancanokur.issuemanagement.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectInput {
    private Long id;
    @NotNull
    private String projectCode;
    @NotNull
    private String projectName;
}

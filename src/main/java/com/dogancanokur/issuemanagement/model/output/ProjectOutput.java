package com.dogancanokur.issuemanagement.model.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectOutput {
    private Long id;
    private String projectCode;
    private String projectName;
}

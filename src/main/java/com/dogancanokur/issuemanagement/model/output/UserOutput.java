package com.dogancanokur.issuemanagement.model.output;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "User Output DTO")
public class UserOutput {

    @ApiModelProperty(value = "User real name and surname")
    private String nameSurname;

    @ApiModelProperty(value = "User username")
    private String username;
}

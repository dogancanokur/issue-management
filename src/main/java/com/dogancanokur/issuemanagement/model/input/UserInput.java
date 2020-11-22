package com.dogancanokur.issuemanagement.model.input;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "User Input DTO")
public class UserInput {
    private String nameSurname;
    private String username;
    private String email;
    private String password;

}

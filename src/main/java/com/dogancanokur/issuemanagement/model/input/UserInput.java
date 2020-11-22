package com.dogancanokur.issuemanagement.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInput {
    private String nameSurname;
    private String username;
    private String email;
    private String password;

}

package com.dogancanokur.issuemanagement.model.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOutput {
    private String nameSurname;
    private String username;
}

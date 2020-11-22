package com.dogancanokur.issuemanagement.service;

import com.dogancanokur.issuemanagement.model.input.UserInput;
import com.dogancanokur.issuemanagement.model.output.UserOutput;
import com.dogancanokur.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserOutput save(UserInput user);

    UserOutput getOne(Long id);

    TPage<UserOutput> findAll(Pageable pageable);

    UserOutput getByUsername(String username);
}

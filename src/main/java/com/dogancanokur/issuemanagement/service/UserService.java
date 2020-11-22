package com.dogancanokur.issuemanagement.service;

import com.dogancanokur.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User save(User user);

    User getOne(Long id);

    Page<User> findAll(Pageable pageable);

    User getByUsername(String username);
}

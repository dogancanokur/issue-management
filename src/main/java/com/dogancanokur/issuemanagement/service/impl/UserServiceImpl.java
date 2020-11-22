package com.dogancanokur.issuemanagement.service.impl;

import com.dogancanokur.issuemanagement.entity.User;
import com.dogancanokur.issuemanagement.repository.UserRepository;
import com.dogancanokur.issuemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if (!"".equals(user.getEmail())) {
            throw new IllegalArgumentException("Email cannot be null!");
        }
        if (!"".equals(user.getUsername())) {
            throw new IllegalArgumentException("Username cannot be null!");
        }
        if (!"".equals(user.getPassword())) {
            throw new IllegalArgumentException("Password cannot be null!");
        }
        return userRepository.save(user);
    }

    @Override
    public User getOne(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

}

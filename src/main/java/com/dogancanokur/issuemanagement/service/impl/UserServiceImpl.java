package com.dogancanokur.issuemanagement.service.impl;

import com.dogancanokur.issuemanagement.entity.User;
import com.dogancanokur.issuemanagement.model.input.UserInput;
import com.dogancanokur.issuemanagement.model.output.UserOutput;
import com.dogancanokur.issuemanagement.repository.UserRepository;
import com.dogancanokur.issuemanagement.service.UserService;
import com.dogancanokur.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserOutput save(UserInput userInput) {
        if (!"".equals(userInput.getEmail())) {
            throw new IllegalArgumentException("Email cannot be null!");
        }
        if (!"".equals(userInput.getUsername())) {
            throw new IllegalArgumentException("Username cannot be null!");
        }
        if (!"".equals(userInput.getPassword())) {
            throw new IllegalArgumentException("Password cannot be null!");
        }
        User user = modelMapper.map(userInput, User.class);
        return modelMapper.map(userRepository.save(user), UserOutput.class);

    }

    @Override
    public UserOutput getOne(Long id) {
        return modelMapper.map(userRepository.getOne(id), UserOutput.class);
    }

    @Override
    public TPage<UserOutput> findAll(Pageable pageable) {
        TPage<UserOutput> page = new TPage<>();
        Page<User> userPage = userRepository.findAll(pageable);
        UserOutput[] userOutputs = modelMapper.map(userPage.getContent(), UserOutput[].class);
        page.setStats(userPage, Arrays.asList(userOutputs));
        return page;
    }

    @Override
    public UserOutput getByUsername(String username) {
        return modelMapper.map(userRepository.getByUsername(username), UserOutput.class);
    }

}

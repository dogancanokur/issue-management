package com.dogancanokur.issuemanagement.service;

import com.dogancanokur.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    Project save(Project project);

    Project getOne(Long id);

    Page<Project> findAll(Pageable pageable);

    Boolean deleteProject(Project project);

    List<Project> getAllByProjectCode(String projectCode);

    List<Project> getAllByProjectCodeAndProjectNameContains(String projectCode, String projectName);
}

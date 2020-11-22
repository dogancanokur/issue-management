package com.dogancanokur.issuemanagement.service.impl;

import com.dogancanokur.issuemanagement.entity.Project;
import com.dogancanokur.issuemanagement.repository.ProjectRepository;
import com.dogancanokur.issuemanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {
        if (project.getProjectCode() == null) {
            throw new IllegalArgumentException("Project code cannot be null!");
        }

        return projectRepository.save(project);
    }

    @Override
    public Project getOne(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public Page<Project> findAll(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean deleteProject(Project project) {
        projectRepository.delete(project);
        return Boolean.TRUE;
    }

    @Override
    public List<Project> getAllByProjectCode(String projectCode) {
        return projectRepository.getAllByProjectCode(projectCode);
    }

    @Override
    public List<Project> getAllByProjectCodeAndProjectNameContains(String projectCode, String projectName) {
        return projectRepository.getAllByProjectCodeAndProjectNameContains(projectCode, projectName);
    }
}

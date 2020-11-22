package com.dogancanokur.issuemanagement.service.impl;

import com.dogancanokur.issuemanagement.entity.Project;
import com.dogancanokur.issuemanagement.model.input.ProjectInput;
import com.dogancanokur.issuemanagement.model.output.ProjectOutput;
import com.dogancanokur.issuemanagement.repository.ProjectRepository;
import com.dogancanokur.issuemanagement.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectOutput save(ProjectInput projectInput) {
        if (projectInput.getProjectCode() == null) {
            throw new IllegalArgumentException("Project code cannot be null!");
        }

        Project project = modelMapper.map(projectInput, Project.class);
        return modelMapper.map(projectRepository.save(project), ProjectOutput.class);
    }

    @Override
    public ProjectOutput getOne(Long id) {
        return modelMapper.map(projectRepository.getOne(id), ProjectOutput.class);
    }

    @Override
    public Page<ProjectOutput> findAll(Pageable pageable) {
//        return projectRepository.findAll(pageable);
        return null;
    }

    @Override
    public Boolean deleteProject(Project project) {
        projectRepository.delete(project);
        return Boolean.TRUE;
    }

    @Override
    public List<ProjectOutput> getAllByProjectCode(String projectCode) {
        return null;
//        return projectRepository.getAllByProjectCode(projectCode);
    }

    @Override
    public List<ProjectOutput> getAllByProjectCodeAndProjectNameContains(String projectCode, String projectName) {
        return null;
//        return projectRepository.getAllByProjectCodeAndProjectNameContains(projectCode, projectName);
    }
}

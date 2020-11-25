package com.dogancanokur.issuemanagement.service.impl;

import com.dogancanokur.issuemanagement.entity.Project;
import com.dogancanokur.issuemanagement.model.input.ProjectInput;
import com.dogancanokur.issuemanagement.model.output.ProjectOutput;
import com.dogancanokur.issuemanagement.repository.ProjectRepository;
import com.dogancanokur.issuemanagement.service.ProjectService;
import com.dogancanokur.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
        if (projectRepository.getByProjectCode(projectInput.getProjectCode()) == null) {
            Project project = modelMapper.map(projectInput, Project.class);
            return modelMapper.map(projectRepository.save(project), ProjectOutput.class);
        } else {
            throw new IllegalArgumentException("Project Code exist!");
        }
    }

    @Override
    public ProjectOutput getOne(Long id) {
        return modelMapper.map(projectRepository.getOne(id), ProjectOutput.class);
    }

    @Override
    public TPage<ProjectOutput> findAll(Pageable pageable) {
        TPage<ProjectOutput> page = new TPage<>();
        Page<Project> projectList = projectRepository.findAll(pageable);
        ProjectOutput[] projectOutputs = modelMapper.map(projectList.getContent(), ProjectOutput[].class);
        page.setStats(projectList, Arrays.asList(projectOutputs));
        return page;
    }

    @Override
    public Boolean deleteProject(Long id) {
        try {
            projectRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<ProjectOutput> getAllByProjectCode(String projectCode) {

        List<Project> allByProjectCode = projectRepository.getAllByProjectCode(projectCode);
        List<ProjectOutput> outputList = Arrays.asList(modelMapper.map(allByProjectCode, ProjectOutput[].class));
        return outputList;
    }

    @Override
    public List<ProjectOutput> getAllByProjectCodeAndProjectNameContains(String projectCode, String projectName) {
        List<Project> allByProjectCodeAndProjectNameContains = projectRepository.getAllByProjectCodeAndProjectNameContains(projectCode, projectName);
        List<ProjectOutput> outputList = Arrays.asList(modelMapper.map(allByProjectCodeAndProjectNameContains, ProjectOutput[].class));
        return outputList;
    }

    @Override
    public List<ProjectOutput> getAll() {
        List<Project> projectList = projectRepository.findAll();
        return Arrays.asList(modelMapper.map(projectList, ProjectOutput[].class));

    }

    @Override
    public ProjectOutput update(Long id, ProjectInput projectInput) {
        Project project = projectRepository.getOne(id);
        if (project == null) {
            throw new IllegalArgumentException("project not found for id = " + id);
        }
        Project projectByProjectCode = projectRepository.getByProjectCodeAndIdNot(projectInput.getProjectCode(), id);

        if (projectByProjectCode != null) {
            throw new IllegalArgumentException("project code already exist!");
        }
        project.setProjectCode(projectInput.getProjectCode());
        project.setProjectName(projectInput.getProjectName());
        return modelMapper.map(projectRepository.save(project), ProjectOutput.class);
    }
}

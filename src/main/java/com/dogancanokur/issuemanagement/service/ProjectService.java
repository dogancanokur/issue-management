package com.dogancanokur.issuemanagement.service;

import com.dogancanokur.issuemanagement.model.input.ProjectInput;
import com.dogancanokur.issuemanagement.model.output.ProjectOutput;
import com.dogancanokur.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    ProjectOutput save(ProjectInput projectInput);

    ProjectOutput getOne(Long id);

    TPage<ProjectOutput> findAll(Pageable pageable);

    Boolean deleteProject(Long id);

    List<ProjectOutput> getAllByProjectCode(String projectCode);

    List<ProjectOutput> getAllByProjectCodeAndProjectNameContains(String projectCode, String projectName);

    List<ProjectOutput> getAll();

    ProjectOutput update(Long id, ProjectInput projectInput);
}

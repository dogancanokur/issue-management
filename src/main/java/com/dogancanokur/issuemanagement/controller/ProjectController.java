package com.dogancanokur.issuemanagement.controller;

import com.dogancanokur.issuemanagement.model.input.ProjectInput;
import com.dogancanokur.issuemanagement.model.output.ProjectOutput;
import com.dogancanokur.issuemanagement.service.ProjectService;
import com.dogancanokur.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value = "Project APIs")
@Slf4j
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "get by id operation")
    public ResponseEntity<ProjectOutput> getById(@PathVariable(value = "id", required = true) Long id) {
        log.info("ProjectController -> GetById");// response time
        log.debug("ProjectController -> GetById -> PARAM :" + id);// parametreler vs
        // errorda tum detay
        ProjectOutput output = projectService.getOne(id);

        return ResponseEntity.ok(output);
    }

    @GetMapping("/all")
    @ApiOperation(value = "get all operation")
    public ResponseEntity<List<ProjectOutput>> getAllProject() {
        List<ProjectOutput> outputList = projectService.getAll();
        return ResponseEntity.ok(outputList);
    }

    @PostMapping("/")
    @ApiOperation(value = "save project operation", response = ProjectOutput.class)
    public ResponseEntity<ProjectOutput> createProject(@Valid @RequestBody ProjectInput input) {
        ProjectOutput output = projectService.save(input);
        return ResponseEntity.ok(output);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "update project operation", response = ProjectOutput.class)
    public ResponseEntity<ProjectOutput> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectInput projectInput) {
        ProjectOutput projectOutput = projectService.update(id, projectInput);
        return ResponseEntity.ok(projectOutput);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete project operation", response = Boolean.class)
    public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id", required = true) Long id) {

        return ResponseEntity.ok(projectService.deleteProject(id));
    }
}

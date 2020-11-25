package com.dogancanokur.issuemanagement.controller;

import com.dogancanokur.issuemanagement.model.output.ProjectOutput;
import com.dogancanokur.issuemanagement.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/versioning")
@Api(value = "Project APIs")
public class ProjectVersiondApi {
    private final ProjectService projectService;

    public ProjectVersiondApi(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(value = "/all", params = "version=1")
    // localhost:9000/versioning/all?version=1
    @ApiOperation(value = "get all operation V1")
    public ResponseEntity<List<ProjectOutput>> getAllProjectV1() {
        List<ProjectOutput> outputList = projectService.getAll();
        return ResponseEntity.ok(outputList);
    }

    @GetMapping(value = "/all", params = "version=2")
    // localhost:9000/versioning/all?version=2
    @ApiOperation(value = "get all operation V2")
    public ResponseEntity<List<ProjectOutput>> getAllProjectV2() {
        List<ProjectOutput> outputList = projectService.getAll();
        return ResponseEntity.ok(outputList);
    }
}

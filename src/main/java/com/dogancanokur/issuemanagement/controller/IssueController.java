package com.dogancanokur.issuemanagement.controller;

import com.dogancanokur.issuemanagement.model.input.IssueInput;
import com.dogancanokur.issuemanagement.model.output.IssueOutput;
import com.dogancanokur.issuemanagement.service.IssueService;
import com.dogancanokur.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueOutput> getById(
            @PathVariable(value = "id", required = true) Long id) {

        IssueOutput output = issueService.getByID(id);
        return ResponseEntity.ok(output);
    }

    @GetMapping("/all")
    public ResponseEntity<List<IssueOutput>> getAllIssues() {
        List<IssueOutput> outputList = issueService.getAll();
        return ResponseEntity.ok(outputList);
    }

    @PostMapping("/")
    public ResponseEntity<IssueOutput> createIssue(@Valid @RequestBody IssueInput input) {
        IssueOutput output = issueService.save(input);
        return ResponseEntity.ok(output);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueOutput> updateProject(
            @PathVariable(value = "id", required = true) Long id, @Valid @RequestBody IssueInput input) {
        IssueOutput output = issueService.update(id, input);
        return ResponseEntity.ok(output);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id", required = true) Long id) {

        return ResponseEntity.ok(issueService.deleteIssue(id));
    }
}

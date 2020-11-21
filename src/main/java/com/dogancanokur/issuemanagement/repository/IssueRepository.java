package com.dogancanokur.issuemanagement.repository;

import com.dogancanokur.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}

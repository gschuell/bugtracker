package com.rti.bugtracker.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by gschuell on 10/17/16.
 */
public interface DCIssues extends JpaRepository<DCIssuesEntity, Long> {

    List<DCIssuesEntity> findAll();

    List<DCIssuesEntity> findAllByOrderByBugIdAsc();

    List<DCIssuesEntity> findByAssignedTo(String userLogin);

    //@Query("select Distinct bugsadmin.assigned_to from #{#entityName}")
    List<DCIssuesEntity> findDistinctDCIssuesByAssignedTo();

}

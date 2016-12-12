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

    List<DCIssuesEntity> findByAssignedTo(String assignedTo);

    //@Query("select Distinct u.assignedto from #{#entityName} u")
    @Query("select Distinct u.assignedTo from #{#entityName} u order by u.assignedTo")
    List<String> findAssignedUsers();

    @Query("select Distinct u.problemType from #{#entityName} u order by u.problemType")
    List<String> findProblemTypes();

    @Query("select u from #{#entityName} u where u.bugStatus = ?")
    List<DCIssuesEntity> findAllIssuesByBugStatus(String bugStatus);

}

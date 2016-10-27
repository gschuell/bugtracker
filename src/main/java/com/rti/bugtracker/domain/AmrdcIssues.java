package com.rti.bugtracker.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by gschuell on 10/17/16.
 */
public interface AmrdcIssues extends JpaRepository<AmrdcIssuesEntity, Long> {

    List<AmrdcIssuesEntity> findAll();
}

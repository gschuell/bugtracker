package com.rti.bugtracker.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by gschuell on 10/20/16.
 */
public interface AmrIssues extends JpaRepository<AmrIssuesEntity, Long> {

    List<AmrIssuesEntity> findAll();
}


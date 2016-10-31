package com.rti.bugtracker.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by gschuell on 10/20/16.
 */
public interface AmrIssues extends JpaRepository<AmrIssuesEntity, Long> {

    List<AmrIssuesEntity> findAll();

    List<AmrIssuesEntity> findByUserLogin(String userLogin);

    @Query("select Distinct amr.userLogin from #{#entityName} amr")
    List<String> findUserLogins();
}


package com.rti.bugtracker.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by gschuell on 10/17/16.
 */
public interface DCIssues extends JpaRepository<SavedDCIssuesEntity, Long> {

    List<SavedDCIssuesEntity> findAll();

    List<SavedDCIssuesEntity> findAllByOrderByBugIdAsc();

    List<SavedDCIssuesEntity> findByUserLogin(String userLogin);

    @Query("select Distinct bugsadmin.user_login from #{#entityName} amr")
    List<String> findUserLogins();

}

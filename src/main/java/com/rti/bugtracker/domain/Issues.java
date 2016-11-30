package com.rti.bugtracker.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by gschuell on 10/20/16.
 */
public interface Issues extends JpaRepository<IssuesEntity, Long> {

    List<IssuesEntity> findAllByOrderByBugIdAsc();

    List<IssuesEntity> findByUserLogin(String userLogin);

    @Query("select Distinct u.userLogin from #{#entityName} u")
    List<IssuesEntity> findUserLogins();

    //@Query("select * from #{#entityName} amr order by :sequence")
    //List<SavedDCIssuesEntity>findByBugIdOrderByBugIdAsc();
}


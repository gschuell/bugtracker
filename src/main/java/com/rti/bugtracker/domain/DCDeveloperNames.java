package com.rti.bugtracker.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by gschuell on 12/27/16.
 */
public interface DCDeveloperNames extends JpaRepository<DCDeveloperNamesEntity, String>{

    @Query("select u.name from #{#entityName} u order by u.name")
    public List<String> findDeveloperNames();

}

package com.rti.bugtracker.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by gschuell on 12/1/16.
 */
public interface DCCategory extends JpaRepository<DCCategoriesEntity, Long>{

    //@Query("SELECT u.dcCategoryName from #{#entityName} u order by u.dcCategoryId")
    //List<String> findCategoryNames();
}

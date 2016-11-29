package com.rti.bugtracker.util;

import com.rti.bugtracker.domain.DCIssuesEntity;

import java.util.Comparator;

/**
 * Created by gschuell on 11/1/16.
 */
public interface DCIssuesComparators extends Comparator<DCIssuesEntity> {


    @Override
    int compare(DCIssuesEntity o1, DCIssuesEntity o2);

    @Override
    boolean equals(Object obj);

    public Comparator getComparators();

}

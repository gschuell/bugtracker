package com.rti.bugtracker.util;

import com.rti.bugtracker.domain.AmrIssuesEntity;

import java.util.Comparator;

/**
 * Created by gschuell on 11/1/16.
 */
public interface AmrIssuesComparators extends Comparator<AmrIssuesEntity> {


    @Override
    int compare(AmrIssuesEntity o1, AmrIssuesEntity o2);

    @Override
    boolean equals(Object obj);

    public Comparator getComparators( );

}

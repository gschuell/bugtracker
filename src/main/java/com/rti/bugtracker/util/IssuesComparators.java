package com.rti.bugtracker.util;

import com.rti.bugtracker.domain.DCIssuesEntity;
import com.rti.bugtracker.domain.IssuesEntity;

import java.util.Comparator;

/**
 * Created by gschuell on 11/1/16.
 */
public interface IssuesComparators extends Comparator<IssuesEntity> {


    @Override
    int compare(IssuesEntity o1, IssuesEntity o2);

    @Override
    boolean equals(Object obj);

    public Comparator getComparators();

}

package com.rti.bugtracker.util;

import com.rti.bugtracker.domain.SavedDCIssuesEntity;

import java.util.Comparator;

/**
 * Created by gschuell on 11/1/16.
 */
public interface DCIssuesComparators extends Comparator<SavedDCIssuesEntity> {


    @Override
    int compare(SavedDCIssuesEntity o1, SavedDCIssuesEntity o2);

    @Override
    boolean equals(Object obj);

    public Comparator getComparators();

}

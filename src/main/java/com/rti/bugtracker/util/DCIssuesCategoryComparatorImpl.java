package com.rti.bugtracker.util;

import com.rti.bugtracker.domain.SavedDCIssuesEntity;

import java.util.Comparator;

/**
 * Created by gschuell on 11/1/16.
 */
public class DCIssuesCategoryComparatorImpl implements DCIssuesComparators {

    public final Comparator<SavedDCIssuesEntity> comparator =
            (e1, e2) -> (e1.getBugCategory().compareToIgnoreCase(e2.getBugCategory()));

    public Comparator getComparators() {
        return comparator;
    }


    @Override
    public int compare(SavedDCIssuesEntity o1, SavedDCIssuesEntity o2) {
        return 0;
    }
}

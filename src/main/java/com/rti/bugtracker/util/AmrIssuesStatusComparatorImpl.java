package com.rti.bugtracker.util;

import com.rti.bugtracker.domain.AmrIssuesEntity;

import java.util.Comparator;

/**
 * Created by gschuell on 11/1/16.
 */
public class AmrIssuesStatusComparatorImpl implements AmrIssueComparators {

    public final Comparator<AmrIssuesEntity> statusComparator =
            (e1, e2) -> (e1.getBugStatus().compareToIgnoreCase(e2.getBugStatus()));

    @Override
    public int compare(AmrIssuesEntity o1, AmrIssuesEntity o2) {
        return 0;
    }
}

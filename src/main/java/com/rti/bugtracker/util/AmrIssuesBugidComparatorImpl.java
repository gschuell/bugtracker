package com.rti.bugtracker.util;

import com.rti.bugtracker.domain.AmrIssuesEntity;

import java.util.Comparator;

/**
 * Created by gschuell on 11/1/16.
 */
public class AmrIssuesBugidComparatorImpl implements AmrIssuesComparators {

    public final Comparator<AmrIssuesEntity> comparator =
            (e1, e2) -> ((int) e1.getBugId() - (int) e2.getBugId());

    public AmrIssuesBugidComparatorImpl() {

    }

    @Override
    public Comparator getComparators() {
        return comparator;
    }

    @Override
    public int compare(AmrIssuesEntity o1, AmrIssuesEntity o2) {
        return 0;
    }
}

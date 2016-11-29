package com.rti.bugtracker.util;

import com.rti.bugtracker.domain.IssuesEntity;

import java.util.Comparator;

/**
 * Created by gschuell on 11/1/16.
 */
public class DCIssuesStatusComparatorImpl implements IssuesComparators {

    public final Comparator<IssuesEntity> comparator =
            (e1, e2) -> (e1.getBugStatus().compareToIgnoreCase(e2.getBugStatus()));

   @Override
    public Comparator getComparators() {
        return comparator;
    }


    @Override
    public int compare(IssuesEntity o1, IssuesEntity o2) {
        return 0;
    }
}

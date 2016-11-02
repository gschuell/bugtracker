package com.rti.bugtracker.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gschuell on 11/1/16.
 */

public class AmrIssuesComparatorStore {

    private Map<String, AmrIssuesComparators> amrComparatorMap =
            new HashMap<String, AmrIssuesComparators>();

    public AmrIssuesComparatorStore() {

        amrComparatorMap.put("bugId", (AmrIssuesComparators) new AmrIssuesBugidComparatorImpl().getComparators());
        amrComparatorMap.put("category", (AmrIssuesComparators)new AmrIssuesCategoryComparatorImpl().getComparators());
        amrComparatorMap.put("status", (AmrIssuesComparators) new AmrIssuesStatusComparatorImpl().getComparators());
    }

    public AmrIssuesComparators getComparator(String key) {
        return amrComparatorMap.get(key);
    }
}

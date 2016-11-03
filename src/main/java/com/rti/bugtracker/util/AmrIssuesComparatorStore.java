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

        amrComparatorMap.put("bugId", (AmrIssuesComparators) new AmrIssuesBugidComparatorImpl());
        amrComparatorMap.put("category", (AmrIssuesComparators)new AmrIssuesCategoryComparatorImpl());
        amrComparatorMap.put("status", (AmrIssuesComparators) new AmrIssuesStatusComparatorImpl());
    }

    public AmrIssuesComparators getComparator(String key) {
        return amrComparatorMap.get(key);
    }
}

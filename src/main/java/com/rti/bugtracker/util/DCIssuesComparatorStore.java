package com.rti.bugtracker.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gschuell on 11/1/16.
 */

 public class DCIssuesComparatorStore {

    private Map<String, IssuesComparators> amrComparatorMap =
            new HashMap<String, IssuesComparators>();

    public DCIssuesComparatorStore() {

        amrComparatorMap.put("bugId", (IssuesComparators) new IssuesBugidComparatorImpl());
        amrComparatorMap.put("category", (IssuesComparators)new IssuesCategoryComparatorImpl());
        amrComparatorMap.put("status", (IssuesComparators) new DCIssuesStatusComparatorImpl());
    }

    public IssuesComparators getComparator(String key) {
        return amrComparatorMap.get(key);
    }
}

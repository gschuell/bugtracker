package com.rti.bugtracker.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gschuell on 11/1/16.
 */

 public class DCIssuesComparatorStore {

    private Map<String, DCIssuesComparators> amrComparatorMap =
            new HashMap<String, DCIssuesComparators>();

    public DCIssuesComparatorStore() {

        amrComparatorMap.put("bugId", (DCIssuesComparators) new DCIssuesBugidComparatorImpl());
        amrComparatorMap.put("category", (DCIssuesComparators)new DCIssuesCategoryComparatorImpl());
        amrComparatorMap.put("status", (DCIssuesComparators) new DCIssuesStatusComparatorImpl());
    }

    public DCIssuesComparators getComparator(String key) {
        return amrComparatorMap.get(key);
    }
}

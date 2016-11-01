package com.rti.bugtracker.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gschuell on 11/1/16.
 */
@Component
public class ComparatorStore {

    private Map<String, AmrIssueComparators> amrComparatorMap =
            new HashMap<String, AmrIssueComparators>();

    public ComparatorStore() {

        amrComparatorMap.put("bugId", new AmrIssuesBugidComparatorImpl());
        amrComparatorMap.put("category", new AmrIssuesCategoryComparatorImpl());
        amrComparatorMap.put("status", new AmrIssuesStatusComparatorImpl());
    }

    public AmrIssueComparators getComparator(String key) {
        return amrComparatorMap.get(key);
    }
}

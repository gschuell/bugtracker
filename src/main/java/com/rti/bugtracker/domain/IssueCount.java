package com.rti.bugtracker.domain;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by gschuell on 1/19/17.
 */
public class IssueCount {

    private AtomicLong issueCount;

    public AtomicLong getIssueCount() {
        return issueCount;
    }

    public long incrementIssueCount() {
        return issueCount.incrementAndGet();
    }
}

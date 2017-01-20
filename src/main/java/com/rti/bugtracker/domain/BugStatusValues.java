package com.rti.bugtracker.domain;

/**
 * Created by gschuell on 1/5/17.
 */
public class BugStatusValues {

    private static String[] statuses = {"Open", "Display All", "Pending", "AwaitingResponse",
            "Resolved",  "Rework" , "DC Reviewed"};

    private static String[] priority = {"      ", "Low", "Medium", "High"};


    public static String[] getStatuses() {
        return statuses;
    }

    public static String[] getPriority() { return priority; }



}

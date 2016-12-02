package com.rti.bugtracker.util;

import com.rti.bugtracker.domain.DCIssuesEntity;

import java.util.List;

/**
 * Created by gschuell on 12/2/16.
 */
public class SearchRequestData {

    public List<DCIssuesEntity> issuesList;
    public List<String> categoriesList;
    public List<String> assignedUserList;

    public SearchRequestData(List<DCIssuesEntity> issues,
                             List<String> categories,
                             List<String> assignedUsers) {

        this.issuesList = issues;
        this.categoriesList = categories;
        this.assignedUserList = assignedUsers;
    }

    public List<DCIssuesEntity> getIssuesList() {
        return issuesList;
    }

    public void setIssuesList(List<DCIssuesEntity> issuesList) {
        this.issuesList = issuesList;
    }

    public List<String> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(List<String> categoriesList) {
        this.categoriesList = categoriesList;
    }

    public List<String> getAssignedUserList() {
        return assignedUserList;
    }

    public void setAssignedUserList(List<String> assignedUserList) {
        this.assignedUserList = assignedUserList;
    }
}
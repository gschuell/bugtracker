package com.rti.bugtracker.bizlogic;

/**
 * Created by gschuell on 12/14/16.
 */
public class AdminDisplayForm {

    private String status;
    private String issueId;
    private String provider;
    private String parentDocumentNumber;
    private String payor;
    private String practice;
    private String checkNum;
    private String checkDate;
    private String problemType;
    private String assignedTo;
    private String startDate;
    private String endDate;


    /**
     * Want form to default to display all Issue IDs for a given status.
     */
    public AdminDisplayForm() {

        issueId = "All";

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getParentDocumentNumber() {
        return parentDocumentNumber;
    }

    public void setParentDocumentNumber(String parentDocumentNumber) {
        this.parentDocumentNumber = parentDocumentNumber;
    }

    public String getPayor() {
        return payor;
    }

    public void setPayor(String payor) {
        this.payor = payor;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public String getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(String checkNum) {
        this.checkNum = checkNum;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


}

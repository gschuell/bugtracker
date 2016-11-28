package com.rti.bugtracker.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by gschuell on 10/14/16.
 */
@Entity
@Table(name = "ISSUES", schema = "BUGSADMIN", catalog = "")
public class IssuesEntity {
    @Id
    @Column(name = "BUG_ID", nullable = false, precision = 0)
    private long bugId;
    @Column(name = "BUG_ENTERED_DATE", nullable = false)
    private Timestamp bugEnteredDate;
    @Column(name = "BUG_FIXED_DATE", nullable = true)
    private Timestamp bugFixedDate;
    @Column(name = "BUG_PRACTICE", nullable = true, length = 3)
    private String bugPractice;
    @Column(name = "BUG_DIVISION", nullable = true, length = 3)
    private String bugDivision;
    @Column(name = "BUG_DATE_OF_SERVICE", nullable = true)
    private Timestamp bugDateOfService;
    @Column(name = "BUG_ACTIVITY", nullable = true, length = 31)
    private String bugActivity;
    @Column(name = "BUG_TITLE", nullable = true, length = 40)
    private String bugTitle;
    @Column(name = "BUG_DESIRED_ACTION", nullable = false, length = 1000)
    private String bugDesiredAction;
    @Column(name = "BUG_RESULT", nullable = true, length = 1000)
    private String bugResult;
    @Column(name = "BUG_STATUS", nullable = true, length = 20)
    private String bugStatus;
    @Column(name = "REPORTED_BY_FIRSTNAME", nullable = true, length = 20)
    private String reportedByFirstname;
    @Column(name = "REPORTED_BY_LASTNAME", nullable = true, length = 20)
    private String reportedByLastname;
    @Column(name = "FIXED_BY_FIRSTNAME", nullable = true, length = 20)
    private String fixedByFirstname;
    @Column(name = "FIXED_BY_LASTNAME", nullable = true, length = 20)
    private String fixedByLastname;
    @Column(name = "FIX_DESCRIPTION", nullable = true, length = 1000)
    private String fixDescription;
    @Column(name = "BUG_COMMENTS", nullable = true, length = 1000)
    private String bugComments;
    @Column(name = "USER_LOGIN", nullable = true, length = 30)
    private String userLogin;
    @Column(name = "BUG_CATEGORY", nullable = false, length = 40)
    private String bugCategory;
    @Column(name = "BUG_DESIRED_RESULT", nullable = true, length = 1000)
    private String bugDesiredResult;
    @Column(name = "BUG_DISCOVERED_DATE", nullable = true)
    private Timestamp bugDiscoveredDate;
    @Column(name = "ASSIGNED_TO", nullable = true, length = 40)
    private String assignedTo;
    @Column(name = "BUG_PRIORITY", nullable = true, length = 20)
    private String bugPriority;



    public long getBugId() {
        return bugId;
    }

    public void setBugId(long bugId) {
        this.bugId = bugId;
    }

    public String getBugEnteredDate() {
        return bugEnteredDate.toString();
    }

    public void setBugEnteredDate(Timestamp bugEnteredDate) {
        this.bugEnteredDate = bugEnteredDate;
    }

    public String getBugFixedDate() {
        if (bugFixedDate == null) {
            return " ";
        }
        return bugFixedDate.toString();
    }

    public void setBugFixedDate(Timestamp bugFixedDate) {
        this.bugFixedDate = bugFixedDate;
    }

    public String getBugPractice() {
        return bugPractice;
    }

    public void setBugPractice(String bugPractice) {
        this.bugPractice = bugPractice;
    }

    public String getBugDivision() {
        return bugDivision;
    }

    public void setBugDivision(String bugDivision) {
        this.bugDivision = bugDivision;
    }

    public String getBugDateOfService() {
        if (bugDateOfService == null) {
            return " ";
        }
        return bugDateOfService.toString();
    }

    public void setBugDateOfService(Timestamp bugDateOfService) {
        this.bugDateOfService = bugDateOfService;
    }

    public String getBugActivity() {
        return bugActivity;
    }

    public void setBugActivity(String bugActivity) {
        this.bugActivity = bugActivity;
    }

    public String getBugTitle() {
        return bugTitle;
    }

    public void setBugTitle(String bugTitle) {
        this.bugTitle = bugTitle;
    }

    public String getBugDesiredAction() {
        return bugDesiredAction;
    }

    public void setBugDesiredAction(String bugDesiredAction) {
        this.bugDesiredAction = bugDesiredAction;
    }

    public String getBugResult() {
        return bugResult;
    }

    public void setBugResult(String bugResult) {
        this.bugResult = bugResult;
    }

    public String getBugStatus() {
        return bugStatus;
    }

    public void setBugStatus(String bugStatus) {
        this.bugStatus = bugStatus;
    }

    @Basic

    public String getReportedByFirstname() {
        return reportedByFirstname;
    }

    public void setReportedByFirstname(String reportedByFirstname) {
        this.reportedByFirstname = reportedByFirstname;
    }

    public String getReportedByLastname() {
        return reportedByLastname;
    }

    public void setReportedByLastname(String reportedByLastname) {
        this.reportedByLastname = reportedByLastname;
    }

    public String getFixedByFirstname() {
        return fixedByFirstname;
    }

    public void setFixedByFirstname(String fixedByFirstname) {
        this.fixedByFirstname = fixedByFirstname;
    }

    public String getFixedByLastname() {
        return fixedByLastname;
    }

    public void setFixedByLastname(String fixedByLastname) {
        this.fixedByLastname = fixedByLastname;
    }

    public String getFixDescription() {
        return fixDescription;
    }

    public void setFixDescription(String fixDescription) {
        this.fixDescription = fixDescription;
    }

    public String getBugComments() {
        return bugComments;
    }

    public void setBugComments(String bugComments) {
        this.bugComments = bugComments;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
    public String getBugCategory() {
        return bugCategory;
    }

    public void setBugCategory(String bugCategory) {
        this.bugCategory = bugCategory;
    }

    public String getBugDesiredResult() {
        return bugDesiredResult;
    }

    public void setBugDesiredResult(String bugDesiredResult) {
        this.bugDesiredResult = bugDesiredResult;
    }

    public String getBugDiscoveredDate() {
        if (bugDiscoveredDate == null) {
            return " ";
        }
        return bugDiscoveredDate.toString();
    }

    public void setBugDiscoveredDate(Timestamp bugDiscoveredDate) {
        this.bugDiscoveredDate = bugDiscoveredDate;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getBugPriority() {
        return bugPriority;
    }

    public void setBugPriority(String bugPriority) {
        this.bugPriority = bugPriority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IssuesEntity)) return false;

        IssuesEntity that = (IssuesEntity) o;

        if (getBugId() != that.getBugId()) return false;
        if (getBugEnteredDate() != null ? !getBugEnteredDate().equals(that.getBugEnteredDate()) : that.getBugEnteredDate() != null)
            return false;
        if (getBugFixedDate() != null ? !getBugFixedDate().equals(that.getBugFixedDate()) : that.getBugFixedDate() != null)
            return false;
        if (getBugPractice() != null ? !getBugPractice().equals(that.getBugPractice()) : that.getBugPractice() != null)
            return false;
        if (getBugDivision() != null ? !getBugDivision().equals(that.getBugDivision()) : that.getBugDivision() != null)
            return false;
        if (getBugDateOfService() != null ? !getBugDateOfService().equals(that.getBugDateOfService()) : that.getBugDateOfService() != null)
            return false;
        if (getBugActivity() != null ? !getBugActivity().equals(that.getBugActivity()) : that.getBugActivity() != null)
            return false;
        if (getBugTitle() != null ? !getBugTitle().equals(that.getBugTitle()) : that.getBugTitle() != null)
            return false;
        if (getBugDesiredAction() != null ? !getBugDesiredAction().equals(that.getBugDesiredAction()) : that.getBugDesiredAction() != null)
            return false;
        if (getBugResult() != null ? !getBugResult().equals(that.getBugResult()) : that.getBugResult() != null)
            return false;
        if (getBugStatus() != null ? !getBugStatus().equals(that.getBugStatus()) : that.getBugStatus() != null)
            return false;
        if (getReportedByFirstname() != null ? !getReportedByFirstname().equals(that.getReportedByFirstname()) : that.getReportedByFirstname() != null)
            return false;
        if (getReportedByLastname() != null ? !getReportedByLastname().equals(that.getReportedByLastname()) : that.getReportedByLastname() != null)
            return false;
        if (getFixedByFirstname() != null ? !getFixedByFirstname().equals(that.getFixedByFirstname()) : that.getFixedByFirstname() != null)
            return false;
        if (getFixedByLastname() != null ? !getFixedByLastname().equals(that.getFixedByLastname()) : that.getFixedByLastname() != null)
            return false;
        if (getFixDescription() != null ? !getFixDescription().equals(that.getFixDescription()) : that.getFixDescription() != null)
            return false;
        if (getBugComments() != null ? !getBugComments().equals(that.getBugComments()) : that.getBugComments() != null)
            return false;
        if (getUserLogin() != null ? !getUserLogin().equals(that.getUserLogin()) : that.getUserLogin() != null)
            return false;
        if (getBugCategory() != null ? !getBugCategory().equals(that.getBugCategory()) : that.getBugCategory() != null)
            return false;
        if (getBugDesiredResult() != null ? !getBugDesiredResult().equals(that.getBugDesiredResult()) : that.getBugDesiredResult() != null)
            return false;
        if (getBugDiscoveredDate() != null ? !getBugDiscoveredDate().equals(that.getBugDiscoveredDate()) : that.getBugDiscoveredDate() != null)
            return false;
        if (getAssignedTo() != null ? !getAssignedTo().equals(that.getAssignedTo()) : that.getAssignedTo() != null)
            return false;
        return getBugPriority() != null ? getBugPriority().equals(that.getBugPriority()) : that.getBugPriority() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getBugId() ^ (getBugId() >>> 32));
        result = 31 * result + (getBugEnteredDate() != null ? getBugEnteredDate().hashCode() : 0);
        result = 31 * result + (getBugFixedDate() != null ? getBugFixedDate().hashCode() : 0);
        result = 31 * result + (getBugPractice() != null ? getBugPractice().hashCode() : 0);
        result = 31 * result + (getBugDivision() != null ? getBugDivision().hashCode() : 0);
        result = 31 * result + (getBugDateOfService() != null ? getBugDateOfService().hashCode() : 0);
        result = 31 * result + (getBugActivity() != null ? getBugActivity().hashCode() : 0);
        result = 31 * result + (getBugTitle() != null ? getBugTitle().hashCode() : 0);
        result = 31 * result + (getBugDesiredAction() != null ? getBugDesiredAction().hashCode() : 0);
        result = 31 * result + (getBugResult() != null ? getBugResult().hashCode() : 0);
        result = 31 * result + (getBugStatus() != null ? getBugStatus().hashCode() : 0);
        result = 31 * result + (getReportedByFirstname() != null ? getReportedByFirstname().hashCode() : 0);
        result = 31 * result + (getReportedByLastname() != null ? getReportedByLastname().hashCode() : 0);
        result = 31 * result + (getFixedByFirstname() != null ? getFixedByFirstname().hashCode() : 0);
        result = 31 * result + (getFixedByLastname() != null ? getFixedByLastname().hashCode() : 0);
        result = 31 * result + (getFixDescription() != null ? getFixDescription().hashCode() : 0);
        result = 31 * result + (getBugComments() != null ? getBugComments().hashCode() : 0);
        result = 31 * result + (getUserLogin() != null ? getUserLogin().hashCode() : 0);
        result = 31 * result + (getBugCategory() != null ? getBugCategory().hashCode() : 0);
        result = 31 * result + (getBugDesiredResult() != null ? getBugDesiredResult().hashCode() : 0);
        result = 31 * result + (getBugDiscoveredDate() != null ? getBugDiscoveredDate().hashCode() : 0);
        result = 31 * result + (getAssignedTo() != null ? getAssignedTo().hashCode() : 0);
        result = 31 * result + (getBugPriority() != null ? getBugPriority().hashCode() : 0);
        return result;
    }
}

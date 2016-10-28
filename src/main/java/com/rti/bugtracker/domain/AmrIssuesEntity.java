package com.rti.bugtracker.domain;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by gschuell on 10/14/16.
 */
@Entity
@Table(name = "AMR_ISSUES", schema = "BUGSADMIN", catalog = "")
public class AmrIssuesEntity {
    @Id
    @Column(name = "BUG_ID", nullable = false, precision = 0)
    private long bugId;
    @Column(name = "BUG_ENTERED_DATE", nullable = false)
    private Time bugEnteredDate;
    @Column(name = "BUG_FIXED_DATE", nullable = true)
    private Time bugFixedDate;
    @Column(name = "BUG_PRACTICE", nullable = true, length = 3)
    private String bugPractice;
    @Column(name = "BUG_DIVISION", nullable = true, length = 3)
    private String bugDivision;
    @Column(name = "BUG_DATE_OF_SERVICE", nullable = true)
    private Time bugDateOfService;
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
    private Time bugDiscoveredDate;
    @Column(name = "ASSIGNED_TO", nullable = true, length = 40)
    private String assignedTo;
    @Column(name = "BUG_PRIORITY", nullable = true, length = 20)
    private String bugPriority;
    @Column(name = "BUG_REGION", nullable = true, length = 4)
    private String bugRegion;
    @Column(name = "ASSIGNED_TO_2", nullable = true, length = 40)
    private String assignedTo2;
    @Column(name = "ASSIGNED_TO_3", nullable = false, length = 40)
    private String assignedTo3;


    public long getBugId() {
        return bugId;
    }

    public void setBugId(long bugId) {
        this.bugId = bugId;
    }

    public Time getBugEnteredDate() {
        return bugEnteredDate;
    }

    public void setBugEnteredDate(Time bugEnteredDate) {
        this.bugEnteredDate = bugEnteredDate;
    }

    public Time getBugFixedDate() {
        return bugFixedDate;
    }

    public void setBugFixedDate(Time bugFixedDate) {
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

    public Time getBugDateOfService() {
        return bugDateOfService;
    }

    public void setBugDateOfService(Time bugDateOfService) {
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

    public Time getBugDiscoveredDate() {
        return bugDiscoveredDate;
    }

    public void setBugDiscoveredDate(Time bugDiscoveredDate) {
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

    public String getBugRegion() {
        return bugRegion;
    }

    public void setBugRegion(String bugRegion) {
        this.bugRegion = bugRegion;
    }

    public String getAssignedTo2() {
        return assignedTo2;
    }

    public void setAssignedTo2(String assignedTo2) {
        this.assignedTo2 = assignedTo2;
    }

    public String getAssignedTo3() {
        return assignedTo3;
    }

    public void setAssignedTo3(String assignedTo3) {
        this.assignedTo3 = assignedTo3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AmrIssuesEntity that = (AmrIssuesEntity) o;

        if (bugId != that.bugId) return false;
        if (bugEnteredDate != null ? !bugEnteredDate.equals(that.bugEnteredDate) : that.bugEnteredDate != null)
            return false;
        if (bugFixedDate != null ? !bugFixedDate.equals(that.bugFixedDate) : that.bugFixedDate != null) return false;
        if (bugPractice != null ? !bugPractice.equals(that.bugPractice) : that.bugPractice != null) return false;
        if (bugDivision != null ? !bugDivision.equals(that.bugDivision) : that.bugDivision != null) return false;
        if (bugDateOfService != null ? !bugDateOfService.equals(that.bugDateOfService) : that.bugDateOfService != null)
            return false;
        if (bugActivity != null ? !bugActivity.equals(that.bugActivity) : that.bugActivity != null) return false;
        if (bugTitle != null ? !bugTitle.equals(that.bugTitle) : that.bugTitle != null) return false;
        if (bugDesiredAction != null ? !bugDesiredAction.equals(that.bugDesiredAction) : that.bugDesiredAction != null)
            return false;
        if (bugResult != null ? !bugResult.equals(that.bugResult) : that.bugResult != null) return false;
        if (bugStatus != null ? !bugStatus.equals(that.bugStatus) : that.bugStatus != null) return false;
        if (reportedByFirstname != null ? !reportedByFirstname.equals(that.reportedByFirstname) : that.reportedByFirstname != null)
            return false;
        if (reportedByLastname != null ? !reportedByLastname.equals(that.reportedByLastname) : that.reportedByLastname != null)
            return false;
        if (fixedByFirstname != null ? !fixedByFirstname.equals(that.fixedByFirstname) : that.fixedByFirstname != null)
            return false;
        if (fixedByLastname != null ? !fixedByLastname.equals(that.fixedByLastname) : that.fixedByLastname != null)
            return false;
        if (fixDescription != null ? !fixDescription.equals(that.fixDescription) : that.fixDescription != null)
            return false;
        if (bugComments != null ? !bugComments.equals(that.bugComments) : that.bugComments != null) return false;
        if (userLogin != null ? !userLogin.equals(that.userLogin) : that.userLogin != null) return false;
        if (bugCategory != null ? !bugCategory.equals(that.bugCategory) : that.bugCategory != null) return false;
        if (bugDesiredResult != null ? !bugDesiredResult.equals(that.bugDesiredResult) : that.bugDesiredResult != null)
            return false;
        if (bugDiscoveredDate != null ? !bugDiscoveredDate.equals(that.bugDiscoveredDate) : that.bugDiscoveredDate != null)
            return false;
        if (assignedTo != null ? !assignedTo.equals(that.assignedTo) : that.assignedTo != null) return false;
        if (bugPriority != null ? !bugPriority.equals(that.bugPriority) : that.bugPriority != null) return false;
        if (bugRegion != null ? !bugRegion.equals(that.bugRegion) : that.bugRegion != null) return false;
        if (assignedTo2 != null ? !assignedTo2.equals(that.assignedTo2) : that.assignedTo2 != null) return false;
        if (assignedTo3 != null ? !assignedTo3.equals(that.assignedTo3) : that.assignedTo3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (bugId ^ (bugId >>> 32));
        result = 31 * result + (bugEnteredDate != null ? bugEnteredDate.hashCode() : 0);
        result = 31 * result + (bugFixedDate != null ? bugFixedDate.hashCode() : 0);
        result = 31 * result + (bugPractice != null ? bugPractice.hashCode() : 0);
        result = 31 * result + (bugDivision != null ? bugDivision.hashCode() : 0);
        result = 31 * result + (bugDateOfService != null ? bugDateOfService.hashCode() : 0);
        result = 31 * result + (bugActivity != null ? bugActivity.hashCode() : 0);
        result = 31 * result + (bugTitle != null ? bugTitle.hashCode() : 0);
        result = 31 * result + (bugDesiredAction != null ? bugDesiredAction.hashCode() : 0);
        result = 31 * result + (bugResult != null ? bugResult.hashCode() : 0);
        result = 31 * result + (bugStatus != null ? bugStatus.hashCode() : 0);
        result = 31 * result + (reportedByFirstname != null ? reportedByFirstname.hashCode() : 0);
        result = 31 * result + (reportedByLastname != null ? reportedByLastname.hashCode() : 0);
        result = 31 * result + (fixedByFirstname != null ? fixedByFirstname.hashCode() : 0);
        result = 31 * result + (fixedByLastname != null ? fixedByLastname.hashCode() : 0);
        result = 31 * result + (fixDescription != null ? fixDescription.hashCode() : 0);
        result = 31 * result + (bugComments != null ? bugComments.hashCode() : 0);
        result = 31 * result + (userLogin != null ? userLogin.hashCode() : 0);
        result = 31 * result + (bugCategory != null ? bugCategory.hashCode() : 0);
        result = 31 * result + (bugDesiredResult != null ? bugDesiredResult.hashCode() : 0);
        result = 31 * result + (bugDiscoveredDate != null ? bugDiscoveredDate.hashCode() : 0);
        result = 31 * result + (assignedTo != null ? assignedTo.hashCode() : 0);
        result = 31 * result + (bugPriority != null ? bugPriority.hashCode() : 0);
        result = 31 * result + (bugRegion != null ? bugRegion.hashCode() : 0);
        result = 31 * result + (assignedTo2 != null ? assignedTo2.hashCode() : 0);
        result = 31 * result + (assignedTo3 != null ? assignedTo3.hashCode() : 0);
        return result;
    }
}

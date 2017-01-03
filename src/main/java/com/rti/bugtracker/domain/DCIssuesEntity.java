package com.rti.bugtracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by gschuell on 10/14/16.
 */
@Entity
@Table(name = "DC_ISSUES", schema = "BUGSADMIN", catalog = "")
public class DCIssuesEntity {

    @Id
    @Column(name = "BUG_ID", nullable = false, precision = 0)
    private long bugId;
    @Column(name = "BUG_ENTERED_DATE", nullable = false)
    private Timestamp bugEnteredDate;
    public Timestamp getBugEnteredDate() {
        return bugEnteredDate;
    }
    @Column(name = "BUG_FIXED_DATE", nullable = false)
    private Timestamp bugFixedDate;
    public Timestamp getBugFixedDate() {
        return bugFixedDate;
    }
    @Column(name = "BUG_TITLE", nullable = false, length = 40)
    private String bugTitle;
    public String getBugTitle() {
        return bugTitle;
    }
    @Column(name = "BUG_STATUS", nullable = false, length = 20)
    private String bugStatus;
    @Column(name = "BUG_COMMENTS", nullable = false, length = 2000)
    private String bugComments;
    @Column(name = "PROBLEM_TYPE", nullable = false, length = 40)
    private String problemType;
    @Column(name = "REPORTED_BY", nullable = false, length = 20)
    private String reportedBy;
    @Column(name = "ASSIGNED_TO", nullable = false, length = 40)
    private String assignedTo;
    @Column(name = "BUG_PRIORITY", nullable = false, length = 20)
    private String bugPriority;
    @Column(name = "PROVIDER_ID", nullable = false, length = 12)
    private String providerId;
    @Column(name = "PRACTICE", nullable = false, length = 3)
    private String practice;
    @Column(name = "EXTPAYOR", nullable = false, length = 12)
    private String extpayor;
    @Column(name = "PARDOCNO", nullable = false, length = 16)
    private String pardocno;
    @Column(name = "DEPDT", nullable = false, length = 16)
    private Date depdt;
    @Column(name = "CHECKNUM", nullable = false, length = 15)
    private String checknum;
    @Column(name = "CHECKAMT", nullable = false, length = 12)
    private String checkamt;
    @Column(name = "CHECK_DATE", nullable = false, length = 12)
    private Date checkDate;
    @Column(name = "LAST_UPDATED", nullable = false)
    private Timestamp lastUpdated;

    public long getBugId() {
        return bugId;
    }

    public void setBugId(long bugId) {
        this.bugId = bugId;
    }

    public void setBugEnteredDate(Timestamp bugEnteredDate) {
        this.bugEnteredDate = bugEnteredDate;
    }

    public void setBugFixedDate(Timestamp bugFixedDate) {
        this.bugFixedDate = bugFixedDate;
    }

    public void setBugTitle(String bugTitle) {
        this.bugTitle = bugTitle;
    }

    public String getBugStatus() {
        return bugStatus;
    }

    public void setBugStatus(String bugStatus) {
        this.bugStatus = bugStatus;
    }

    public String getBugComments() {
        return bugComments;
    }

    public void setBugComments(String bugComments) {
        this.bugComments = bugComments;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
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

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public String getExtpayor() {
        return extpayor;
    }

    public void setExtpayor(String extpayor) {
        this.extpayor = extpayor;
    }

    public String getPardocno() {
        return pardocno;
    }

    public void setPardocno(String pardocno) {
        this.pardocno = pardocno;
    }

    public Date getDepdt() {
        return depdt;
    }

    public void setDepdt(Date depdt) {
        this.depdt = depdt;
    }

    public String getChecknum() {
        return checknum;
    }

    public void setChecknum(String checknum) {
        this.checknum = checknum;
    }

    public String getCheckamt() {
        return checkamt;
    }

    public void setCheckamt(String checkamt) {
        this.checkamt = checkamt;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DCIssuesEntity that = (DCIssuesEntity) o;

        if (bugId != that.bugId) return false;
        if (bugEnteredDate != null ? !bugEnteredDate.equals(that.bugEnteredDate) : that.bugEnteredDate != null)
            return false;
        if (bugFixedDate != null ? !bugFixedDate.equals(that.bugFixedDate) : that.bugFixedDate != null) return false;
        if (bugTitle != null ? !bugTitle.equals(that.bugTitle) : that.bugTitle != null) return false;
        if (bugStatus != null ? !bugStatus.equals(that.bugStatus) : that.bugStatus != null) return false;
        if (bugComments != null ? !bugComments.equals(that.bugComments) : that.bugComments != null) return false;
        if (problemType != null ? !problemType.equals(that.problemType) : that.problemType != null) return false;
        if (reportedBy != null ? !reportedBy.equals(that.reportedBy) : that.reportedBy != null) return false;
        if (assignedTo != null ? !assignedTo.equals(that.assignedTo) : that.assignedTo != null) return false;
        if (bugPriority != null ? !bugPriority.equals(that.bugPriority) : that.bugPriority != null) return false;
        if (providerId != null ? !providerId.equals(that.providerId) : that.providerId != null) return false;
        if (practice != null ? !practice.equals(that.practice) : that.practice != null) return false;
        if (extpayor != null ? !extpayor.equals(that.extpayor) : that.extpayor != null) return false;
        if (pardocno != null ? !pardocno.equals(that.pardocno) : that.pardocno != null) return false;
        if (depdt != null ? !depdt.equals(that.depdt) : that.depdt != null) return false;
        if (checknum != null ? !checknum.equals(that.checknum) : that.checknum != null) return false;
        if (checkamt != null ? !checkamt.equals(that.checkamt) : that.checkamt != null) return false;
        if (checkDate != null ? !checkDate.equals(that.checkDate) : that.checkDate != null) return false;
        if (lastUpdated != null ? !lastUpdated.equals(that.lastUpdated) : that.lastUpdated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (bugId ^ (bugId >>> 32));
        result = 31 * result + (bugEnteredDate != null ? bugEnteredDate.hashCode() : 0);
        result = 31 * result + (bugFixedDate != null ? bugFixedDate.hashCode() : 0);
        result = 31 * result + (bugTitle != null ? bugTitle.hashCode() : 0);
        result = 31 * result + (bugStatus != null ? bugStatus.hashCode() : 0);
        result = 31 * result + (bugComments != null ? bugComments.hashCode() : 0);
        result = 31 * result + (problemType != null ? problemType.hashCode() : 0);
        result = 31 * result + (reportedBy != null ? reportedBy.hashCode() : 0);
        result = 31 * result + (assignedTo != null ? assignedTo.hashCode() : 0);
        result = 31 * result + (bugPriority != null ? bugPriority.hashCode() : 0);
        result = 31 * result + (providerId != null ? providerId.hashCode() : 0);
        result = 31 * result + (practice != null ? practice.hashCode() : 0);
        result = 31 * result + (extpayor != null ? extpayor.hashCode() : 0);
        result = 31 * result + (pardocno != null ? pardocno.hashCode() : 0);
        result = 31 * result + (depdt != null ? depdt.hashCode() : 0);
        result = 31 * result + (checknum != null ? checknum.hashCode() : 0);
        result = 31 * result + (checkamt != null ? checkamt.hashCode() : 0);
        result = 31 * result + (checkDate != null ? checkDate.hashCode() : 0);
        result = 31 * result + (lastUpdated != null ? lastUpdated.hashCode() : 0);
        return result;
    }
    */
}

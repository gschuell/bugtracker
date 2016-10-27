package com.rti.bugtracker.domain;

import javax.persistence.*;

/**
 * Created by gschuell on 10/14/16.
 */
@Entity
@Table(name = "AMRDC_CATEGORIES", schema = "BUGSADMIN", catalog = "")
public class AmrdcCategoriesEntity {
    @Id
    private Long amrdcCategoryId;
    private Long projectId;
    private String amrdcCategoryName;

    @Basic
    @Column(name = "AMRDC_CATEGORY_ID", nullable = false, precision = 0)
    public Long getAmrdcCategoryId() {
        return amrdcCategoryId;
    }

    public void setAmrdcCategoryId(Long amrdcCategoryId) {
        this.amrdcCategoryId = amrdcCategoryId;
    }

    @Basic
    @Column(name = "PROJECT_ID", nullable = false, precision = 0)
    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "AMRDC_CATEGORY_NAME", nullable = false, length = 40)
    public String getAmrdcCategoryName() {
        return amrdcCategoryName;
    }

    public void setAmrdcCategoryName(String amrdcCategoryName) {
        this.amrdcCategoryName = amrdcCategoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AmrdcCategoriesEntity that = (AmrdcCategoriesEntity) o;

        if (amrdcCategoryId != null ? !amrdcCategoryId.equals(that.amrdcCategoryId) : that.amrdcCategoryId != null)
            return false;
        if (projectId != null ? !projectId.equals(that.projectId) : that.projectId != null) return false;
        if (amrdcCategoryName != null ? !amrdcCategoryName.equals(that.amrdcCategoryName) : that.amrdcCategoryName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = amrdcCategoryId != null ? amrdcCategoryId.hashCode() : 0;
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        result = 31 * result + (amrdcCategoryName != null ? amrdcCategoryName.hashCode() : 0);
        return result;
    }
}

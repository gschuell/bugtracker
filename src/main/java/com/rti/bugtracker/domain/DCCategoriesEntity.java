package com.rti.bugtracker.domain;

import javax.persistence.*;

/**
 * Created by gschuell on 10/14/16.
 */
@Entity
@Table(name = "DC_CATEGORIES", schema = "BUGSADMIN", catalog = "")
public class DCCategoriesEntity {
    @Id
    @Column(name = "DC_CATEGORY_ID", nullable = false, precision = 0)
    private Long dcCategoryId;


    @Column(name = "PROJECT_ID", nullable = false, precision = 0)
    private Long projectId;


    @Column(name = "DC_CATEGORY_NAME", nullable = false, length = 40)
    private String dcCategoryName;


    public Long getdcCategoryId() {
        return dcCategoryId;
    }

    public void setdcCategoryId(Long dcCategoryId) {
        this.dcCategoryId = dcCategoryId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getdcCategoryName() {
        return dcCategoryName;
    }

    public void setdcCategoryName(String dcCategoryName) {
        this.dcCategoryName = dcCategoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DCCategoriesEntity that = (DCCategoriesEntity) o;

        if (dcCategoryId != null ? !dcCategoryId.equals(that.dcCategoryId) : that.dcCategoryId != null)
            return false;
        if (projectId != null ? !projectId.equals(that.projectId) : that.projectId != null) return false;
        if (dcCategoryName != null ? !dcCategoryName.equals(that.dcCategoryName) : that.dcCategoryName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dcCategoryId != null ? dcCategoryId.hashCode() : 0;
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        result = 31 * result + (dcCategoryName != null ? dcCategoryName.hashCode() : 0);
        return result;
    }
}

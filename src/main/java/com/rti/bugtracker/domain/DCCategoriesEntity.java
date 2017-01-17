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
    private Long categoryId;


    @Column(name = "PROJECT_ID", nullable = false, precision = 0)
    private Long projectId;


    @Column(name = "DC_CATEGORY_NAME", nullable = false, length = 40)
    private String categoryName;


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DCCategoriesEntity that = (DCCategoriesEntity) o;

        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null)
            return false;
        if (projectId != null ? !projectId.equals(that.projectId) : that.projectId != null) return false;
        if (categoryName != null ? !categoryName.equals(that.categoryName) : that.categoryName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId != null ? categoryId.hashCode() : 0;
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        return result;
    }
}

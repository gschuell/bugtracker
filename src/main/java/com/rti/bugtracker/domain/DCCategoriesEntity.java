package com.rti.bugtracker.domain;

import javax.persistence.*;

/**
 * Created by gschuell on 10/14/16.
 */
@Entity
@Table(name = "DC_CATEGORIES", schema = "BUGSADMIN", catalog = "")
public class DCCategoriesEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DC_CATEGORIES")
    @SequenceGenerator(name="SEQ_DC_CATEGORIES", sequenceName="SEQ_DC_CATEGORIES", allocationSize = 1)
    @Column(name = "DC_CATEGORY_ID", nullable = false, precision = 10)
    private Long categoryId;


    @Column(name = "PROJECT_ID", nullable = true, precision = 10)
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
        if (!(o instanceof DCCategoriesEntity)) return false;

        DCCategoriesEntity that = (DCCategoriesEntity) o;

        if (getCategoryId() != null ? !getCategoryId().equals(that.getCategoryId()) : that.getCategoryId() != null)
            return false;
        if (getProjectId() != null ? !getProjectId().equals(that.getProjectId()) : that.getProjectId() != null)
            return false;
        return getCategoryName() != null ? getCategoryName().equals(that.getCategoryName()) : that.getCategoryName() == null;
    }

    @Override
    public int hashCode() {
        int result = getCategoryId() != null ? getCategoryId().hashCode() : 0;
        result = 31 * result + (getProjectId() != null ? getProjectId().hashCode() : 0);
        result = 31 * result + (getCategoryName() != null ? getCategoryName().hashCode() : 0);
        return result;
    }
}

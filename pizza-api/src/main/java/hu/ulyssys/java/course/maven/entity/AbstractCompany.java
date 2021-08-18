package hu.ulyssys.java.course.maven.entity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractCompany extends AbstractEntity{

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date", nullable = false)
    private Date modifiedDate;

    @JoinColumn(name = "created_user_id")
    @ManyToOne
    private AppUser createdBy;

    @JoinColumn(name = "modified_user_id")
    @ManyToOne
    private AppUser modifiedBy;

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public AppUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(AppUser createdBy) {
        this.createdBy = createdBy;
    }

    public AppUser getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(AppUser modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}

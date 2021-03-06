package hu.ulyssys.java.course.maven.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
public class MenuItem extends AbstractEntity{
    private String url;
    private String label;
    private Boolean onlyAdminCanSee;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getOnlyAdminCanSee() {
        return onlyAdminCanSee;
    }

    public void setOnlyAdminCanSee(Boolean onlyAdminCanSee) {
        this.onlyAdminCanSee = onlyAdminCanSee;
    }
}

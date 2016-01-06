package net.leidra.pm.shared.pojos;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class AbstractPojo extends AbstractPersistable<Long> implements Pojo {
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected Date lastModifiedDate;

    public void setId(Long id) {
        super.setId(id);
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(final Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @PrePersist
    public void touchForCreate() {
        if (this.isNew()) {
            this.setCreatedDate(new Date());
        }
        this.setLastModifiedDate(new Date());
    }

    @PreUpdate
    public void touchForUpdate() {
        this.setLastModifiedDate(new Date());
    }
}

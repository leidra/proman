package net.leidra.pm.core.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by afuentes on 28/12/15.
 */
@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    @PreUpdate
    public void setModificationDate() {
        this.setModificationDate(new Date());
    }

    @PrePersist
    public void setCreationDate() {
        if(this.getId() == null) {
            this.setCreationDate(new Date());
        }
        this.setModificationDate(new Date());
    }
}
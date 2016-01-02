package net.leidra.pm.shared.dtos;

import java.util.Date;

/**
 * Created by afuentes on 28/12/15.
 */
public class AbstractDto {
    private Long id;
    private Date creationDate;
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
}

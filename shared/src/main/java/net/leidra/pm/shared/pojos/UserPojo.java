package net.leidra.pm.shared.pojos;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class UserPojo extends AbstractPojo {
    @NotNull
    @Size(max = 50)
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

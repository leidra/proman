package net.leidra.pm.shared.pojos;

import javax.validation.constraints.NotNull;

/**
 * Created by afuentes on 4/01/16.
 */
public class CustomerPojo extends AbstractPojo {
    @NotNull
    protected String name;

    public CustomerPojo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

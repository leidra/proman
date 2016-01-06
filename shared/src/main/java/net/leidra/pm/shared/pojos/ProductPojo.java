package net.leidra.pm.shared.pojos;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class ProductPojo extends AbstractPojo {
    @NotNull
    @NotBlank
    @Size(max = 50)
    protected String name;
    @NotNull
    @NotBlank
    @Size(max = 50)
    protected String brand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

package net.leidra.pm.shared.dtos;

/**
 * Created by afuentes on 14/12/15.
 */
public class ProductDto extends AbstractDto {
    private String name;

    public ProductDto() {
    }

    public ProductDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

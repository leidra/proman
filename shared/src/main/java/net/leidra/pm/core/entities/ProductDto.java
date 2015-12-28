package net.leidra.pm.core.entities;

/**
 * Created by afuentes on 14/12/15.
 */
public class ProductDto {
    private Long id;
    private String name;

    public ProductDto() {
    }

    public ProductDto(Product product) {
        this(product.getId(), product.getName());
    }

    public ProductDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

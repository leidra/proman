package net.leidra.pm.core.services;

import net.leidra.pm.core.entities.Product;
import net.leidra.pm.core.entities.ProductDto;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by afuentes on 14/12/15.
 */
@Service
@Scope("session")
@Transactional()
public class ProductService extends AbstractService<Product, ProductDto> {
    public ProductDto save(ProductDto dto) {
        Product product = convertToEntity(dto);
        product = repository.save(product);

        return convertToDto(product);
    }
}

package net.leidra.pm.core.services;

import net.leidra.pm.core.entities.Product;
import net.leidra.pm.shared.dtos.ProductDto;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by afuentes on 14/12/15.
 */
@Service(ProductService.SERVICE_NAME)
@Scope("session")
public class ProductService extends AbstractService<Product, ProductDto> {
    public static final String SERVICE_NAME = "ProductService";

    @Transactional
    protected Product saveTransactional(ProductDto dto) {
        Product product = convertToEntity(dto);
        product = repository.save(product);

        return product;
    }
}

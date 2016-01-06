package net.leidra.pm.core.services;

import net.leidra.pm.core.entities.Product;
import net.leidra.pm.shared.pojos.ProductListPojo;
import net.leidra.pm.shared.pojos.ProductPojo;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by afuentes on 14/12/15.
 */
@Service(ProductService.SERVICE_NAME)
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ProductService extends AbstractService<Product, ProductPojo> {
    public static final String SERVICE_NAME = "ProductService";

    @Transactional
    protected Product saveTransactional(ProductPojo dto) {
        Product product = convertToEntity(dto);

        return repository.saveAndFlush(product);
    }

    public Set<ProductListPojo> findAllForList() {
        List<Product> entities = this.repository.findAll();

        return getMapperFactory().getMapperFacade().mapAsSet(entities, ProductListPojo.class);
    }

}

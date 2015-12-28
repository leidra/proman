package net.leidra.pm.ui.views.products;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Grid;
import net.leidra.pm.core.entities.ProductDto;
import net.leidra.pm.ui.views.AbstractListComponent;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

/**
 * Created by afuentes on 27/12/15.
 */
@SpringComponent
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProductsList extends AbstractListComponent<ProductDto> {

    protected BeanItemContainer createDatasource() {
        return new BeanItemContainer<>(ProductDto.class, presenter.findAll());
    }

    @Override
    protected void editClickListener(Grid.RowReference rowReference) {
        presenter.edit((ProductDto) rowReference.getItemId());
    }
}

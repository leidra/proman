package net.leidra.pm.ui.views.products;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Grid;
import net.leidra.pm.shared.dtos.ProductDto;
import net.leidra.pm.ui.views.AbstractListComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

/**
 * Created by afuentes on 27/12/15.
 */
@SpringComponent
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProductsList extends AbstractListComponent<ProductDto> {

    @Override
    protected void editAction(Grid.RowReference rowReference) {
        presenter.edit((ProductDto) rowReference.getItemId());
    }

    @Override
    protected void removeAction(Grid.RowReference rowReference) {
        presenter.remove((ProductDto) rowReference.getItemId());
        presenter.showList();
    }

    @Autowired
    public void setPresenter(ProductPresenter presenter) {
        this.presenter = presenter;
    }

}

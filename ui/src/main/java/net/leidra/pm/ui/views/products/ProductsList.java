package net.leidra.pm.ui.views.products;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import net.leidra.pm.core.entities.ProductDto;
import net.leidra.pm.ui.views.ListViewComponent;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

/**
 * Created by afuentes on 27/12/15.
 */
@SpringComponent
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProductsList extends AbstractProductViewComponent implements ListViewComponent<ProductDto> {
    private Grid grid;
    private ProductDto value;

    @Override
    protected CssLayout buildView() {
        CssLayout listLayout = new CssLayout();
        listLayout.addStyleName("list-layout");
        listLayout.addComponent(createGrid());
        refresh();

        return listLayout;
    }

    protected Grid createGrid() {
        grid = new Grid();
        grid.addSelectionListener(e -> this.rowSelected());
        return grid;
    }

    public void refresh() {
        grid.setContainerDataSource(createDatasource());
    }

    protected BeanItemContainer createDatasource() {
        return new BeanItemContainer<>(ProductDto.class, presenter.findAll());
    }

    public ProductDto getValue() {
        return value;
    }

    protected void rowSelected() {
        this.value = (ProductDto) grid.getSelectedRow();
        presenter.showEditButton();
    }
}

package net.leidra.pm.ui.views;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.SelectionEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import net.leidra.pm.ui.views.products.AbstractProductViewComponent;

/**
 * Created by afuentes on 28/12/15.
 */
public abstract class AbstractListComponent<BEAN> extends AbstractProductViewComponent implements ListViewComponent<BEAN> {
    protected Grid grid = new Grid();
    protected BEAN value;

    public void refresh() {
        grid.setContainerDataSource(createDatasource());
    }

    @Override
    protected CssLayout buildView() {
        CssLayout listLayout = new CssLayout();
        listLayout.addStyleName("list-layout");
        listLayout.addComponent(createGrid());
        refresh();

        return listLayout;
    }

    protected Grid createGrid() {
        grid.addSelectionListener(this::rowSelected);
        grid.setDetailsGenerator(this::getDetails);
        return grid;
    }

    public Component getDetails(Grid.RowReference rowReference) {
        CssLayout layout = new CssLayout();

        layout.addComponent(new Button("Edit", e -> this.editClickListener(rowReference)));
        return layout;
    }

    public BEAN getValue() {
        return value;
    }

    protected void rowSelected(SelectionEvent e) {
        grid.setDetailsVisible(this.value, false);
        this.value = (BEAN) grid.getSelectedRow();
        grid.setDetailsVisible(this.value, true);
    }

    protected abstract BeanItemContainer createDatasource();

    protected abstract void editClickListener(Grid.RowReference rowReference);
}
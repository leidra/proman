package net.leidra.pm.ui.views.products;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import net.leidra.pm.ui.views.AbstractView;
import net.leidra.pm.ui.views.products.ProductPresenter.ProductPresenter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by afuentes on 14/12/15.
 */
@SpringView(name = ProductView.VIEW_NAME)
public class ProductView extends AbstractView {
    public final static String VIEW_NAME = "Product";

    @Autowired
    protected ProductPresenter presenter;

    private Button newButton = new Button("New", e -> this.showEditor());
    private Button editButton = new Button("Edit", e -> this.edit());
    private Button listButton = new Button("List", e -> this.showList());

    @Autowired
    public void setEditor(ProductEditor editor) {
        this.editor = editor;
    }

    @Autowired
    public void setList(ProductsList list) {
        this.list = list;
    }

    @Override
    protected Component createComponentMenu() {
        editButton.setVisible(false);

        CssLayout layout = new CssLayout();
        layout.addComponent(newButton);
        layout.addComponent(editButton);
        layout.addComponent(listButton);

        return layout;
    }

    public Button getNewButton() {
        return newButton;
    }

    public Button getEditButton() {
        return editButton;
    }

    public Button getListButton() {
        return listButton;
    }

    @Override
    protected ProductPresenter getPresenter() {
        return presenter;
    }
}

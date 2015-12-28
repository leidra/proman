package net.leidra.pm.ui.views.products;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.VerticalLayout;
import net.leidra.pm.ui.views.products.ProductPresenter.ProductPresenter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by afuentes on 27/12/15.
 */
public abstract class AbstractProductViewComponent extends VerticalLayout {
    @Autowired
    protected ProductPresenter presenter;

    @PostConstruct
    public void postConstruct() {
        this.addStyleName("product-view-container");
        this.addComponent(buildView());
    }

    protected abstract CssLayout buildView();
}
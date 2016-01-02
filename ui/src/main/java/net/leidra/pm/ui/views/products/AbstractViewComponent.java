package net.leidra.pm.ui.views.products;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import net.leidra.pm.shared.dtos.AbstractDto;

import javax.annotation.PostConstruct;

/**
 * Created by afuentes on 27/12/15.
 */
public abstract class AbstractViewComponent<BEAN extends AbstractDto> extends CustomComponent {
    protected BEAN bean;
    protected AbstractPresenter<BEAN> presenter;

    @PostConstruct
    public void postConstruct() {
        this.addStyleName("product-view-container");
        this.setCompositionRoot(buildView());
    }

    protected abstract CssLayout buildView();
}

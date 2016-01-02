package net.leidra.pm.ui.views.products;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.UI;
import net.leidra.pm.core.services.AbstractService;
import net.leidra.pm.core.services.Service;
import net.leidra.pm.shared.dtos.ProductDto;
import net.leidra.pm.core.services.ProductService;
import net.leidra.pm.ui.MainUI;
import net.leidra.pm.ui.views.AbstractView;
import net.leidra.pm.ui.views.products.AbstractPresenter;
import net.leidra.pm.ui.views.products.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import java.util.Set;

/**
 * Created by afuentes on 27/12/15.
 */
@SpringComponent(ProductPresenter.PRESENTER_NAME)
@Scope("session")
public class ProductPresenter extends AbstractPresenter<ProductDto> {
    public final static String PRESENTER_NAME = "ProductPresenter";

    public ProductDto save(ProductDto dto, FieldGroup fieldGroup) throws FieldGroup.CommitException {
        fieldGroup.commit();
        return getService().save(dto);
    }

    protected AbstractView getCurrentView() {
        return (AbstractView) ((MainUI) UI.getCurrent()).getViewProvider().getView(ProductView.VIEW_NAME);
    }

    public Set<ProductDto> findAll() {
        return getService().findAll();
    }

    public void showEditor() {
        edit(new ProductDto());
    }

    @Override
    @Autowired
    @Qualifier(ProductService.SERVICE_NAME)
    public void setService(Service service) {
        this.service = service;
    }
}
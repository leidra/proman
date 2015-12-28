package net.leidra.pm.ui.views.products.ProductPresenter;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.UI;
import net.leidra.pm.core.entities.ProductDto;
import net.leidra.pm.core.services.ProductService;
import net.leidra.pm.ui.MainUI;
import net.leidra.pm.ui.views.products.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import java.util.Set;

/**
 * Created by afuentes on 27/12/15.
 */
@SpringComponent
@Scope("session")
public class ProductPresenter {
    @Autowired
    private ProductService service;

    public ProductDto save(ProductDto dto, FieldGroup fieldGroup) {
        try {
            fieldGroup.commit();
        } catch (FieldGroup.CommitException e) {
            e.printStackTrace();
        }
        return service.save(dto);
    }

    public Set<ProductDto> findAll() {
        return service.findAll();
    }

    private ProductView getCurrentView() {
        return (ProductView) ((MainUI)UI.getCurrent()).getViewProvider().getView(ProductView.VIEW_NAME);
    }

    public void showEditButton() {
        getCurrentView().getEditButton().setVisible(true);
    }

    public void hideEditButton() {
        getCurrentView().getEditButton().setVisible(false);
    }
}
package net.leidra.pm.ui.views.products;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import net.leidra.pm.shared.pojos.ProductPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

/**
 * Created by afuentes on 27/12/15.
 */
@SpringComponent
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProductEditor extends AbstractEditorComponent<ProductPojo> {
    private TextField name;
    private TextField brand;

    @Override
    @Autowired
    @Qualifier(ProductPresenter.PRESENTER_NAME)
    public void setPresenter(AbstractPresenter presenter) {
        super.setPresenter(presenter);
    }

    @Override
    protected void configureFields() {
        fieldGroup = new BeanFieldGroup<>(ProductPojo.class);

        name = new TextField("Name");
        brand = new TextField("Brand");

        brand.setNullRepresentation("");
        name.setNullRepresentation("");

        super.configureFields(name, brand);
    }

    @Override
    protected CssLayout createComponentLayout() {
        CssLayout editorLayout = new CssLayout();
        editorLayout.addStyleName("editor-component-container");
        editorLayout.addComponent(createFieldContainer(name));
        editorLayout.addComponent(createFieldContainer(brand));
        editorLayout.addComponent(createFieldContainer(new Button("Save", this::saveAction)));

        return editorLayout;
    }

}
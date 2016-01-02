package net.leidra.pm.ui.views.products;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import net.leidra.pm.shared.dtos.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

/**
 * Created by afuentes on 27/12/15.
 */
@SpringComponent
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProductEditor extends AbstractEditorComponent<ProductDto> {
    private TextField name;

    @Override
    protected CssLayout buildView() {
        fieldGroup = new BeanFieldGroup<>(ProductDto.class);

        name = new TextField("Name");
        name.setNullRepresentation("");

        CssLayout editorLayout = new CssLayout();
        editorLayout.addComponent(name);
        editorLayout.addComponent(new Button("Save", this::saveAction));

        return editorLayout;
    }

    @Autowired
    public void setPresenter(ProductPresenter presenter) {
        this.presenter = presenter;
    }

    protected void saveAction(Button.ClickEvent e) {
        try {
            bean = presenter.save(bean, fieldGroup);
        } catch (FieldGroup.CommitException e1) {
            e1.printStackTrace();
        }
        presenter.showList();
    }
}
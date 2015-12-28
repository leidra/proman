package net.leidra.pm.ui.views.products;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import net.leidra.pm.core.entities.ProductDto;
import net.leidra.pm.ui.views.EditorViewComponent;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

/**
 * Created by afuentes on 27/12/15.
 */
@SpringComponent
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProductEditor extends AbstractProductViewComponent implements EditorViewComponent<ProductDto> {
    TextField name;

    private ProductDto bean;
    private BeanFieldGroup<ProductDto> fieldGroup = new BeanFieldGroup<>(ProductDto.class);

    @Override
    protected CssLayout buildView() {
        name = new TextField("Name");
        name.setNullRepresentation("");

        CssLayout editorLayout = new CssLayout();
        editorLayout.addComponent(name);
        editorLayout.addComponent(new Button("Save", e -> presenter.save(bean, fieldGroup)));

        return editorLayout;
    }

    @Override
    public void setDatasource(ProductDto dto) {
        this.bean = dto;

        fieldGroup.setItemDataSource(bean);
        fieldGroup.bindMemberFields(this);
        fieldGroup.setBuffered(true);
    }
}
package net.leidra.pm.ui.views.products;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.FieldEvents;
import com.vaadin.ui.*;
import net.leidra.pm.shared.pojos.Pojo;
import net.leidra.pm.ui.views.EditorViewComponent;

import java.util.stream.Stream;

/**
 * Created by afuentes on 28/12/15.
 */
public abstract class AbstractEditorComponent<BEAN extends Pojo> extends AbstractViewComponent<BEAN> implements EditorViewComponent<BEAN> {
    protected BeanFieldGroup<BEAN> fieldGroup;

    @Override
    public void setDatasource(BEAN dto) {
        this.bean = dto;

        fieldGroup.setItemDataSource(bean);
        fieldGroup.bindMemberFields(this);
    }

    protected void saveAction(Button.ClickEvent e) {
        bean = presenter.save(fieldGroup);

        if (fieldGroup.isValid()) {
            presenter.showList();
        }
    }

    protected void configureFields(Field... fields) {
        Stream.of(fields).filter(f -> FieldEvents.BlurNotifier.class.isAssignableFrom(f.getClass()))
                .forEach(p -> configureField(p));
    }

    protected void configureField(Field p) {
        FieldEvents.BlurNotifier blurField = (FieldEvents.BlurNotifier) p;
        AbstractField formField = (AbstractField) p;
        formField.setValidationVisible(false);
        blurField.addBlurListener(ev -> formField.setValidationVisible(!formField.isValid()));
    }

    @Override
    protected CssLayout buildView() {
        configureFields();

        return createComponentLayout();
    }

    protected CssLayout createFieldContainer(Component field) {
        CssLayout fieldContainer = new CssLayout();
        fieldContainer.addStyleName("editor-field-container");
        fieldContainer.addComponent(field);

        return fieldContainer;
    }

    protected abstract void configureFields();
    protected abstract CssLayout createComponentLayout();
}
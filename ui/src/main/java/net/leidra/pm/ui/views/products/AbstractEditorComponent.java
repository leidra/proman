package net.leidra.pm.ui.views.products;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.FieldEvents;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.Button;
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
        configureFields();
    }

    protected void saveAction(Button.ClickEvent e) {
        bean = presenter.save(fieldGroup);

        if (fieldGroup.isValid()) {
            presenter.showList();
        }
    }

    private void configureFields() {
        filterEditorFields(FieldEvents.BlurNotifier.class).forEach(p -> {
            try {
                p.setAccessible(true);

                FieldEvents.BlurNotifier blurField = ((FieldEvents.BlurNotifier) p.get(this));
                AbstractField formField = ((AbstractField) p.get(this));
                formField.setValidationVisible(false);
                blurField.addBlurListener(ev -> formField.setValidationVisible(!formField.isValid()));
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
        });
    }

    protected Stream<java.lang.reflect.Field> filterEditorFields(Class cls) {
        return Stream.of(this.getClass().getDeclaredFields())
                .filter(p -> cls.isAssignableFrom(p.getType()));
    }

}

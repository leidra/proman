package net.leidra.pm.ui.views.products;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import net.leidra.pm.shared.dtos.AbstractDto;
import net.leidra.pm.ui.views.EditorViewComponent;

/**
 * Created by afuentes on 28/12/15.
 */
public abstract class AbstractEditorComponent<BEAN extends AbstractDto> extends AbstractViewComponent<BEAN> implements EditorViewComponent<BEAN> {
    protected BeanFieldGroup<BEAN> fieldGroup;

    @Override
    public void setDatasource(BEAN dto) {
        this.bean = dto;

        fieldGroup.setItemDataSource(bean);
        fieldGroup.bindMemberFields(this);
        fieldGroup.setBuffered(true);
    }

}

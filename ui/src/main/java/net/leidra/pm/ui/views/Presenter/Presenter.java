package net.leidra.pm.ui.views.Presenter;

import com.vaadin.data.fieldgroup.FieldGroup;
import net.leidra.pm.core.services.AbstractService;
import net.leidra.pm.core.services.Service;
import net.leidra.pm.shared.dtos.AbstractDto;

import java.util.Set;

/**
 * Created by afuentes on 28/12/15.
 */
public interface Presenter<BEAN extends AbstractDto> {
    BEAN save(BEAN dto, FieldGroup fieldGroup) throws FieldGroup.CommitException;
    Set<BEAN> findAll();

    void showEditor();
    void showList();

    void setService(Service<BEAN> service);
    Service<BEAN> getService();
}

package net.leidra.pm.ui.views.Presenter;

import com.vaadin.data.fieldgroup.FieldGroup;

import java.util.Set;

/**
 * Created by afuentes on 28/12/15.
 */
public interface Presenter<BEAN> {
    BEAN save(BEAN dto, FieldGroup fieldGroup);

    Set<BEAN> findAll();

    void showEditor();
    void showList();
}

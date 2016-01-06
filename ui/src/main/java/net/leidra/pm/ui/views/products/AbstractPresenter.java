package net.leidra.pm.ui.views.products;

import com.vaadin.data.util.BeanItemContainer;
import net.leidra.pm.core.services.Service;
import net.leidra.pm.shared.pojos.Pojo;
import net.leidra.pm.ui.views.AbstractView;
import net.leidra.pm.ui.views.Presenter.Presenter;

import java.lang.reflect.ParameterizedType;

/**
 * Created by afuentes on 28/12/15.
 */
public abstract class AbstractPresenter<BEAN extends Pojo> implements Presenter<BEAN> {
    protected Service<BEAN> service;

    protected abstract AbstractView getCurrentView();

    public void edit(BEAN dto) {
        if (dto.getId() != null) {
            dto = getService().findOne(dto.getId());
        }

        getCurrentView().getEditor().setDatasource(dto);
        getCurrentView().changeViewComponent(getCurrentView().getEditor());
    }

    public void remove(BEAN dto) {
        getService().remove(dto);
        getCurrentView().getEditor().setDatasource(dto);
        getCurrentView().changeViewComponent(getCurrentView().getEditor());
    }

    public void showList() {
        getCurrentView().getList().refresh();
        getCurrentView().changeViewComponent(getCurrentView().getList());
    }

    public BeanItemContainer createDatasource() {
        return new BeanItemContainer<>(getType(), findAll());
    }

    protected Class<BEAN> getType() {
        return (Class<BEAN>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public Service<BEAN> getService() {
        return this.service;
    }
}

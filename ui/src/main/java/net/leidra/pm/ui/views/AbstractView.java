package net.leidra.pm.ui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import net.leidra.pm.core.entities.ProductDto;
import net.leidra.pm.ui.views.products.ProductPresenter.ProductPresenter;

import javax.annotation.PostConstruct;

/**
 * Created by afuentes on 27/12/15.
 */
public abstract class AbstractView<BEAN> extends CssLayout implements View {
    protected ListViewComponent list;
    protected EditorViewComponent editor;
    private CssLayout componentContainer;

    @PostConstruct
    public void postConstruct() {
        this.addStyleName("view-layout");
        CssLayout componentMenuContainer = new CssLayout();
        componentMenuContainer.addStyleName("component-menu-container");
        componentMenuContainer.addComponent(createComponentMenu());
        addComponent(componentMenuContainer);
        componentContainer = new CssLayout();
        componentContainer.addStyleName("component-content-container");
        addComponent(componentContainer);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        showList();
    }

    protected void changeViewComponent(Component component) {
        componentContainer.removeAllComponents();
        componentContainer.addComponent(component);
    }

    protected void showEditor() {
        getPresenter().hideEditButton();
        editor.setDatasource(new ProductDto());
        changeViewComponent(editor);
    }

    protected void edit() {
        editor.setDatasource(list.getValue());
        changeViewComponent(editor);
    }

    protected void showList() {
        getPresenter().hideEditButton();
        list.refresh();
        changeViewComponent(list);
    }

    protected abstract Component createComponentMenu();

    protected abstract ProductPresenter getPresenter();
}

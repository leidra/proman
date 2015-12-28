package net.leidra.pm.ui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import net.leidra.pm.ui.views.Presenter.Presenter;

import javax.annotation.PostConstruct;

/**
 * Created by afuentes on 27/12/15.
 */
public abstract class AbstractView<BEAN> extends CustomComponent implements View {
    protected ListViewComponent list;
    protected EditorViewComponent editor;
    private CssLayout componentContainer = new CssLayout();

    protected Button newButton = new Button("New", e -> getPresenter().showEditor());
    protected Button listButton = new Button("List", e -> getPresenter().showList());

    protected Presenter presenter;

    @PostConstruct
    public void postConstruct() {
        this.addStyleName("view-layout");

        CssLayout rootLayout = new CssLayout();
        rootLayout.addStyleName("component-container");
        rootLayout.addComponent(createComponentMenu());

        componentContainer.addStyleName("component-content-container");
        rootLayout.addComponent(componentContainer);

        setCompositionRoot(rootLayout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        getPresenter().showList();
    }

    public void changeViewComponent(Component component) {
        componentContainer.removeAllComponents();
        componentContainer.addComponent(component);
    }

    protected Component createComponentMenu() {
        CssLayout componentMenuContainer = new CssLayout();
        componentMenuContainer.addStyleName("component-menu-container");

        componentMenuContainer.addComponent(newButton);
        componentMenuContainer.addComponent(listButton);

        return componentMenuContainer;
    }

    protected Presenter getPresenter() {
        return presenter;
    }

    protected abstract void setPresenter(Presenter presenter);

    public ListViewComponent getList() {
        return list;
    }

    public EditorViewComponent getEditor() {
        return editor;
    }
}
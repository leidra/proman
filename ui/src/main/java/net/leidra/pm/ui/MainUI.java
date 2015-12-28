package net.leidra.pm.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import net.leidra.pm.ui.views.AccessDeniedView;
import net.leidra.pm.ui.views.ErrorView;
import net.leidra.pm.ui.views.products.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.security.util.SecurityExceptionUtils;

/**
 * Created by afuentes on 14/12/15.
 */
@SpringUI
@Theme(MainUI.THEME_NAME)
public class MainUI extends UI {
    public final static String THEME_NAME = "mytheme";
    @Autowired
    private SpringViewProvider viewProvider;
    private CssLayout contentContainer;

    @Override
    protected void init(VaadinRequest request) {
        // Let's register a custom error handler to make the 'access denied' messages a bit friendlier.
        setErrorHandler(createErrorHandler());
        this.setContent(createUILayout());

        configureNavigator();
    }

    private CssLayout createUILayout() {
        CssLayout uiLayout = new CssLayout();
        uiLayout.addStyleName("ui-container");
        uiLayout.addComponent(this.createHeader());
        uiLayout.addComponent(this.createViewContainer());
        uiLayout.addComponent(this.createFooter());

        return uiLayout;
    }

    private Component createViewContainer() {
        CssLayout viewContainer = new CssLayout();
        viewContainer.addStyleName("view-container");
        viewContainer.addComponent(this.createMenu());
        viewContainer.addComponent(this.createContent());

        return viewContainer;
    }

    private Component createHeader() {
        CssLayout headerContainer = new CssLayout();
        headerContainer.addStyleName("header-container");
        return headerContainer;
    }

    private Component createMenu() {
        CssLayout menuContainer = new CssLayout();
        menuContainer.addStyleName("menu-container");
        menuContainer.addComponent(new Button("Products",
                e -> getUI().getNavigator().navigateTo(ProductView.VIEW_NAME)));
        menuContainer.addComponent(new Button("Logout",
                e -> getPage().setLocation("/logout")));
        return menuContainer;
    }

    private Component createContent() {
        contentContainer = new CssLayout();
        contentContainer.addStyleName("content-container");
        return contentContainer;
    }

    private Component createFooter() {
        CssLayout footerContainer = new CssLayout();
        footerContainer.addStyleName("footer-container");
        return footerContainer;
    }

    public void configureNavigator() {
        Navigator navigator = new Navigator(this, contentContainer);

        viewProvider.setAccessDeniedViewClass(AccessDeniedView.class);
        navigator.addProvider(viewProvider);
        navigator.setErrorView(ErrorView.class);
        this.setNavigator(navigator);
    }

    protected ErrorHandler createErrorHandler() {
        return new DefaultErrorHandler() {
            @Override
            public void error(com.vaadin.server.ErrorEvent event) {
                if (SecurityExceptionUtils.isAccessDeniedException(event.getThrowable())) {
                    Notification.show("Sorry, you don't have access to do that.");
                } else {
                    super.error(event);
                }
            }
        };
    }

    public SpringViewProvider getViewProvider() {
        return viewProvider;
    }
}
package net.leidra.pm.ui.views;

import com.vaadin.ui.Component;

/**
 * Created by afuentes on 27/12/15.
 */
public interface ListViewComponent<BEAN> extends Component {
    void refresh();

    BEAN getValue();
}

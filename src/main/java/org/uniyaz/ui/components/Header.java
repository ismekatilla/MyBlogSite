package org.uniyaz.ui.components;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class Header extends VerticalLayout {

    public Header() {
        setSizeFull();
        buildHeaderLayout();
    }

    private void buildHeaderLayout() {
        Label headerLabel= new Label("Hoşgeldiniz ");
        headerLabel.setSizeUndefined();
        addComponent(headerLabel);

        setComponentAlignment(headerLabel, Alignment.MIDDLE_CENTER);
    }
}

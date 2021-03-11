package org.uniyaz.ui.components;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class Footer extends HorizontalLayout {

    public Footer() {
        setSizeFull();
        buildFooterLayout();
    }

    private void buildFooterLayout() {
        Label footerLabel= new Label("Copyright 2021 Universal");
        footerLabel.setSizeUndefined();
        addComponent(footerLabel);

        setComponentAlignment(footerLabel, Alignment.MIDDLE_CENTER);
    }
}

package org.uniyaz.ui.components;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class MyContent extends VerticalLayout {

    public MyContent() {
        setSizeFull();
        buildContentLayout();
    }

    private void buildContentLayout() {
        Label lbl = new Label("MyContent");
        addComponent(lbl);
    }

    public void setContent(Component component) {
        this.removeAllComponents();
        addComponent(component);
    }

    public MyContent getContent(){
        return this;
    }

    @Override
    public void addComponent(Component c) {
        removeAllComponents();
        super.addComponent(c);
    }
}
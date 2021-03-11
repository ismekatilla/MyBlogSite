package org.uniyaz.ui.fields;

import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;

import java.awt.*;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class MySidebarButton extends Button {

    public MySidebarButton(String caption){
        super();
        setCaption(caption);
        setWidth(99, Sizeable.Unit.PERCENTAGE);
        setHeight(50, Sizeable.Unit.PIXELS);
    }
}

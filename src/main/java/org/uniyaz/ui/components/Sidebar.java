package org.uniyaz.ui.components;

import com.vaadin.ui.VerticalLayout;
import org.uniyaz.ui.view.SidebarPage;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class Sidebar extends VerticalLayout {
    private MyContent myContent;
    private SidebarPage sidebarPage;

    public Sidebar(MyContent myContent) {
        setSizeFull();

        sidebarPage = new SidebarPage(myContent);

        addComponent(sidebarPage);
    }

    public MyContent getMyContent() {
        return myContent;
    }

    public void setMyContent(MyContent myContent) {
        this.myContent = myContent;
    }

    public SidebarPage getSidebarPage() {
        return sidebarPage;
    }

    public void setSidebarPage(SidebarPage sidebarPage) {
        this.sidebarPage = sidebarPage;
    }
}

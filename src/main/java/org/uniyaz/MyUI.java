package org.uniyaz;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import org.uniyaz.ui.components.MyContent;
import org.uniyaz.ui.components.Main;
import org.uniyaz.ui.components.Sidebar;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("org.uniyaz.MyAppWidgetset")
public class MyUI extends UI {

    private MyContent myContent;
    private Sidebar sideBar;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Main main = new Main();

        setContent(main);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

    public MyContent getMyContent() {
        return myContent;
    }

    public void setMyContent(MyContent myContent) {
        this.myContent = myContent;
    }

    public Sidebar getSideBar() {
        return sideBar;
    }

    public void setSideBar(Sidebar sideBar) {
        this.sideBar = sideBar;
    }
}

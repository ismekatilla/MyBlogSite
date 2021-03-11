package org.uniyaz.ui.view;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.uniyaz.core.domain.Makale;
import org.uniyaz.core.service.MakaleService;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class MakaleDeletePage extends VerticalLayout {
    Makale makale;
    Button yes;
    Button no;
    Window myDeleteWindow;

    public MakaleDeletePage(Makale makale) {
        this.makale = makale;
        buildMainLayout(makale);
    }

    private void buildMainLayout(Makale makale) {

        HorizontalLayout mesaj = new HorizontalLayout();
        Label lbl = new Label("");
        lbl.setValue(makale.getBaslik());
        mesaj.addComponent(lbl);
        addComponent(mesaj);


        HorizontalLayout buttonlar = new HorizontalLayout();
        yes = new Button("Sil");
        yes.setIcon(FontAwesome.TRASH);
        yes.addStyleName(ValoTheme.BUTTON_DANGER);
        yes.setWidth("130px");
        buttonlar.addComponent(yes);

        no = new Button("Vazgeç");
        no.addStyleName(ValoTheme.BUTTON_FRIENDLY);
        no.setWidth("130px");
        buttonlar.addComponent(no);

        addComponent(buttonlar);

        makaleSil(this.makale);
    }

    private void makaleSil(Makale makale) {
        yes.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    MakaleService makaleService = new MakaleService();
                    makaleService.deleteMakale(makale);
                    Notification.show(makale.getBaslik() + " Başlıklı Makale silindi !");
                    UI.getCurrent().getUI().removeWindow(getMyDeleteWindow());
                } catch (Exception exception) {
                    Notification.show(exception.getMessage());
                }
            }
        });

        no.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().getUI().removeWindow(getMyDeleteWindow());
            }
        });

    }

    public Window getMyDeleteWindow() {
        return myDeleteWindow;
    }

    public void setMyDeleteWindow(Window myDeleteWindow) {
        this.myDeleteWindow = myDeleteWindow;
    }
}
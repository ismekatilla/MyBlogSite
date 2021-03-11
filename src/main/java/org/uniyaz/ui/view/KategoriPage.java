package org.uniyaz.ui.view;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import org.uniyaz.MyUI;
import org.uniyaz.core.domain.Kategori;
import org.uniyaz.core.service.KategoriService;
import org.uniyaz.ui.components.Sidebar;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class KategoriPage extends FormLayout {

    @PropertyId("id")
    TextField idField;

    @PropertyId("adi")
    TextField adiField;

    Button kaydetButton;
    Sidebar sidebar;

    BeanItem<Kategori> kategoriBeanItem;
    FieldGroup binder;

    public KategoriPage(Kategori kategori) {
        MyUI myUI = (MyUI) UI.getCurrent();
        this.sidebar = myUI.getSideBar();

        buildLayout();

        kategoriBeanItem = new BeanItem<Kategori>(kategori);
        binder = new FieldGroup(kategoriBeanItem);
        binder.bindMemberFields(this);
    }

    private void buildLayout() {

        idField = new TextField();
        idField.setCaption("ID");
        idField.setNullRepresentation("");
        addComponent(idField);

        adiField = new TextField();
        adiField.setCaption("Adı");
        adiField.setNullRepresentation("");
        addComponent(adiField);

        buildKategoriButton();
        addComponent(kaydetButton);
    }

    private void buildKategoriButton() {
        kaydetButton = new Button("Kaydet");
        kaydetButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    binder.commit();
                    Kategori kategori = kategoriBeanItem.getBean();

                    KategoriService kategoriService = new KategoriService();
                    kategoriService.saveKategori(kategori);
                    Notification.show(kategori.getAdi() + " Eklendi");

                    sidebar.getSidebarPage().fillSidebar();

                }catch (Exception hata){
                    Notification.show("Eklenemedi ! ");
                }
            }
        });
    }
}

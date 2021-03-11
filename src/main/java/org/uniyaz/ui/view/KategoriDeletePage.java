package org.uniyaz.ui.view;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import org.uniyaz.core.domain.Kategori;
import org.uniyaz.core.service.KategoriService;
import org.uniyaz.ui.components.Sidebar;
import org.uniyaz.ui.fields.KategoriComboField;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class KategoriDeletePage extends VerticalLayout {
    private KategoriComboField kategoriComboField;
    private Button buttonKategoriyiSil;
    private KategoriService kategoriService;
    private Sidebar sidebar;

    public KategoriDeletePage(Sidebar sidebar) {
        buildMainLayout();
        this.sidebar = sidebar;
    }

    public void buildMainLayout() {
        kategoriComboField = new KategoriComboField();
        kategoriComboField.setCaption("Silinecek Kategoriyi Seçin !");
        kategoriComboField.setRequired(true);
        addComponent(kategoriComboField);

        buildKategoriDeleteButton();
        addComponent(buttonKategoriyiSil);

        //Binder olmadan Silme işlemi
        /*
        kategoriComboField.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent){
                Kategori kategori = (Kategori) valueChangeEvent.getProperty().getValue();
                if (kategori == null) return;
                kategori1.setId(kategori.getId());
                kategori1.setAd(kategori.getAd());
            }
        });
        */
        //Kategori value = (Kategori) kategoriComboField.getValue();
    }

    private void buildKategoriDeleteButton() {
        buttonKategoriyiSil = new Button("Sil");
        buttonKategoriyiSil.setIcon(FontAwesome.TRASH_O);
        buttonKategoriyiSil.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                deleteKategori();
            }
        });
    }

    private void deleteKategori() {
        try {
            Kategori selectedKategori = (Kategori) kategoriComboField.getValue();
            if (selectedKategori != null) {
                kategoriService = new KategoriService();
                kategoriService.deleteKategori(selectedKategori);
                kategoriComboField.fillComboBox();

                sidebar.getSidebarPage().fillSidebar();

                Notification.show(selectedKategori.getAdi() + " Kategorisi silindi !");
            } else {
                Notification.show("Silinecek Kategoriyi Seçmediniz !");
            }
        } catch (Exception exception) {
            Notification.show(exception.getMessage());
        }
    }
}

package org.uniyaz.ui.view;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import org.uniyaz.MyUI;
import org.uniyaz.core.domain.Kategori;
import org.uniyaz.core.service.KategoriService;
import org.uniyaz.ui.components.MyContent;

import java.util.List;

public class KategoriListelePage extends HorizontalLayout {

    private Table table;
    private Container container;

    public KategoriListelePage() {

        setSizeFull();

        buildLayout();
        fillTable();
    }

    private void buildLayout() {
        buildTable();
        addComponent(table);
    }

    private void buildTable() {

        table = new Table();
        table.setSizeFull();

        buildContainer();
        table.setContainerDataSource(container);
        table.setColumnHeaders("ID", "ADI", "");
    }

    private void fillTable() {

        KategoriService kategoriService = new KategoriService();
        List<Kategori> kategoriList = kategoriService.kategoriListing();
        for (Kategori kategori : kategoriList) {
            Item item = container.addItem(kategori);
            item.getItemProperty("id").setValue(kategori.getId());
            item.getItemProperty("adi").setValue(kategori.getAdi());

            Button guncelle = new Button();
            guncelle.setIcon(FontAwesome.EDIT);
            guncelle.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {
                    KategoriPage kategoriPage = new KategoriPage(kategori);

                    MyUI myUI = (MyUI) UI.getCurrent();
                    MyContent myContent = myUI.getMyContent();
                    myContent.addComponent(kategoriPage);
                }
            });
            item.getItemProperty("guncelle").setValue(guncelle);
        }
    }

    private void buildContainer() {
        container = new IndexedContainer();
        container.addContainerProperty("id", Integer.class, null);
        container.addContainerProperty("adi", String.class, null);
        container.addContainerProperty("guncelle", Button.class, null);
    }
}
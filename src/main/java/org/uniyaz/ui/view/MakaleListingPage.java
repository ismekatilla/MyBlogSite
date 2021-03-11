package org.uniyaz.ui.view;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.uniyaz.core.domain.Makale;
import org.uniyaz.core.service.MakaleService;

import java.util.Date;
import java.util.List;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class MakaleListingPage extends VerticalLayout {
    Table table;
    IndexedContainer indexedContainer;

    public MakaleListingPage() {
        buildTableIndexedContainer();
        buildTable();
        fillTable();
        addComponent(new Label("<h3>Makale Tablosu</h3>", ContentMode.HTML));
        addComponent(table);
    }
    private void buildTableIndexedContainer() {

        indexedContainer = new IndexedContainer();

        indexedContainer.addContainerProperty("guncelle", Button.class,null);
        indexedContainer.addContainerProperty("sil",Button.class,null);
        indexedContainer.addContainerProperty("izle",Button.class,null);

        indexedContainer.addContainerProperty("id", Integer.class, null);
        indexedContainer.addContainerProperty("baslik", String.class, null);
        indexedContainer.addContainerProperty("kayitTarihi", Date.class, null);
        indexedContainer.addContainerProperty("detay", String.class, null);
        indexedContainer.addContainerProperty("yazar", String.class, null);
        indexedContainer.addContainerProperty("id_kategori", Integer.class, null);
    }

    private void buildTable() {
        table = new Table();
        table.setContainerDataSource(indexedContainer);

        table.setWidth("100%");
        table.setSelectable(true);
        table.setMultiSelectMode(MultiSelectMode.SIMPLE);
        table.setMultiSelect(false);
        //Tablo Başlıkları
        table.setColumnHeaders("","","","ID", "Başlık", "Kayıt Tarihi", "Detay", "Yazar", "ID Kategorisi");

        table.setColumnWidth("guncelle",70);
        table.setColumnAlignment("guncelle", Table.Align.LEFT);
        table.setColumnWidth("sil",70);
        table.setColumnAlignment("sil", Table.Align.LEFT);
        table.setColumnWidth("izle",70);
        table.setColumnAlignment("izle", Table.Align.LEFT);
    }

    private void fillTable() {
        indexedContainer.removeAllItems();
        MakaleService makaleService = new MakaleService();
        List<Makale> makaleList = makaleService.findAllMakale();

        for (Makale makale : makaleList) {
            Item item = indexedContainer.addItem(makale);

            //Makale Güncelleme
            Button editButton=new Button();
            makaleGuncelle(makale,editButton);

            //Makale Silme
            Button trashButton=new Button();
            makaleSil(makale,trashButton);

            //Makale Göster
            Button infoButton=new Button();
            makaleDetayGoster(makale,infoButton);

            //Kolonları Doldurma
            fillColumns(makale,item,editButton,trashButton,infoButton);
        }

    }

    private void makaleDetayGoster(Makale makale, Button infoButton) {

    }

    private void makaleSil(Makale makale, Button trashButton) {
        trashButton.setIcon(FontAwesome.TRASH);
        trashButton.addStyleName(ValoTheme.BUTTON_DANGER);
        trashButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Window makaleDeleteWindow = new Window("Makale Silme");
                makaleDeleteWindow.setWidth("25%");
                makaleDeleteWindow.setHeight("200px");

                MakaleDeletePage urunDeletePage=new MakaleDeletePage(makale);
                urunDeletePage.setMyDeleteWindow(makaleDeleteWindow);
                urunDeletePage.setMargin(true);

                makaleDeleteWindow.setContent(urunDeletePage);
                makaleDeleteWindow.center();
                makaleDeleteWindow.addCloseListener(new Window.CloseListener() {
                    @Override
                    public void windowClose(Window.CloseEvent closeEvent) {
                        fillTable();
                    }
                });
                UI.getCurrent().addWindow(makaleDeleteWindow);
            }
        });
    }

    private void makaleGuncelle(Makale makale, Button editButton) {

    }

    private void fillColumns(Makale makale, Item item, Button editButton, Button trashButton, Button infoButton) {
        item.getItemProperty("guncelle").setValue(editButton);
        item.getItemProperty("sil").setValue(trashButton);
        item.getItemProperty("izle").setValue(infoButton);
//
        item.getItemProperty("id").setValue(makale.getId());
        item.getItemProperty("baslik").setValue(makale.getBaslik());
        item.getItemProperty("kayitTarihi").setValue(makale.getKayitTarihi());
        item.getItemProperty("detay").setValue(makale.getDetay());
        item.getItemProperty("yazar").setValue(makale.getYazar());
        item.getItemProperty("id_kategori").setValue(makale.getId_kategori());
    }

}

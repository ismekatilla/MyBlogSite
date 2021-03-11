package org.uniyaz.ui.fields;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import org.uniyaz.core.domain.Kategori;
import org.uniyaz.core.domain.Makale;
import org.uniyaz.core.service.MakaleService;
import org.uniyaz.ui.components.MyContent;

import java.util.List;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class MakaleItemsGrid extends GridLayout {
    private Kategori kategori;
    private double satirSayisi;

    private MyContent myContent;

    private MakaleService makaleService = new MakaleService();
    private List<Makale> allMakaleByKategori;

    public MakaleItemsGrid(Kategori kategori, MyContent myContent) {
        this.myContent = myContent;
        this.kategori = kategori;
        allMakaleByKategori = makaleService.findAllMakaleByKategori(kategori);
        satirSayisi = Math.ceil(allMakaleByKategori.size() / 3);
        if (satirSayisi >= 1) {
            buildGrid(satirSayisi);
        }else{
            Notification.show("Kategoriye Ait Makale Bulanamadı !");
        }

    }

    private void buildGrid(double satirSayisi) {
        addStyleName("outlined");
        setSizeFull();
        fillItemsGrid((int) satirSayisi, 3);
    }

    private void fillItemsGrid(final int rows, final int columns) {
        removeAllComponents();
        setRows(rows);
        setColumns(columns);
        setWidth(100.0f,Unit.PERCENTAGE);

        int count = 0;
        for (Makale makale : allMakaleByKategori) {

            VerticalLayout makaleItem = new VerticalLayout();

            makaleItem.setWidth("200");
            makaleItem.setHeight("500");

            Image image = new Image();
            image.setWidth("200");
            image.setWidth("100");
            image.setCaption("Resim");

            count += 1;
            Label labelMakaleBaslikAndCount = new Label();
            labelMakaleBaslikAndCount.setValue(count + "----------------------" + makale.getBaslik());

            Label labelMakaleTarihAndKategori = new Label();
            labelMakaleTarihAndKategori.setValue(makale.getKayitTarihi().toString() + "-------" + kategori);

            Label labelMakaleKisaDetay = new Label();
            if (makale.getDetay().length() > 100){
                labelMakaleKisaDetay.setValue(makale.getDetay().substring(0, 100) + " ...");
            }else{
                labelMakaleKisaDetay.setValue(makale.getDetay()+ " ...");
            }

            Button detayaGitButton = new Button("Devamı");
            detayaGitButton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {
                    makaleItem.removeComponent(labelMakaleKisaDetay);
                    makaleItem.removeComponent(detayaGitButton);

                    Label labelMakaleDetay = new Label();
                    labelMakaleDetay.setValue(makale.getDetay());

                    makaleItem.addComponent(labelMakaleDetay);

                    Label labelMakaleYazar = new Label();
                    labelMakaleYazar.setValue("Yazar " + makale.getYazar());
                    makaleItem.addComponent(labelMakaleYazar);

                    makaleItem.setSizeFull();
                    makaleItem.setHeight(null);

                    myContent.setContent(makaleItem);
                }
            });
            detayaGitButton.setIcon(FontAwesome.ARROW_CIRCLE_O_RIGHT);

            makaleItem.addComponent(image);
            makaleItem.addComponent(labelMakaleBaslikAndCount);
            makaleItem.addComponent(labelMakaleTarihAndKategori);
            makaleItem.addComponent(labelMakaleKisaDetay);
            makaleItem.addComponent(detayaGitButton);

            addComponent(makaleItem);
        }
    }
}

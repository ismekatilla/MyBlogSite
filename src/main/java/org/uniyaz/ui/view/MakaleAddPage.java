package org.uniyaz.ui.view;

import com.vaadin.ui.*;
import org.uniyaz.core.domain.Kategori;
import org.uniyaz.core.domain.Makale;
import org.uniyaz.core.service.MakaleService;
import org.uniyaz.ui.fields.KategoriComboField;

import java.util.Date;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class MakaleAddPage extends VerticalLayout {
    private Makale makale = new Makale(0,"",new Date(),"","",0);

    KategoriComboField makaleKategorisiComboBox;
    TextField baslikTextField;
    DateField kayitTarihiDateField;
    TextArea detayTextArea;
    TextField yazarTextField;
    Button makaleEkleButton;

    public MakaleAddPage() {
        buildMakaleAddView();
    }

    private void buildMakaleAddView() {
        makaleKategorisiComboBox = new KategoriComboField();
        makaleKategorisiComboBox.setCaption("Makalenin Kategorisi");
        addComponent(makaleKategorisiComboBox);

        baslikTextField = new TextField("Makalenin Başlığı");
        addComponent(baslikTextField);

        kayitTarihiDateField = new DateField("Kayıt Tarihi");
        kayitTarihiDateField.setDateFormat("yyyy.MM.dd");
        addComponent(kayitTarihiDateField);

        detayTextArea = new TextArea("Makale Detayı");
        addComponent(detayTextArea);

        yazarTextField = new TextField("Yazarı");
        addComponent(yazarTextField);

        makaleEkleButton = new Button("Ekle");
        addComponent(makaleEkleButton);
        makaleEkleButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Kategori kategori = (Kategori) makaleKategorisiComboBox.getValue();
                makale.setId_kategori(kategori.getId());
                makale.setBaslik(baslikTextField.getValue());
                makale.setKayitTarihi(kayitTarihiDateField.getValue());
                makale.setDetay(detayTextArea.getValue());
                makale.setYazar(yazarTextField.getValue());

                MakaleService makaleService = new MakaleService();
                try {
                    makaleService.makaleEkle(makale);
                    Notification.show(kategori.getAdi() + " Adlı Kategoriye Makale Eklendi");
                    formuTemizle();
                } catch (Exception exception) {
                    Notification.show("Makale Eklenemedi !");
                }
            }
        });
    }

    private void formuTemizle() {
        makaleKategorisiComboBox.setValue(null);
        baslikTextField.setValue("");
        kayitTarihiDateField.setValue(null);
        yazarTextField.setValue("");
        detayTextArea.setValue("");
    }

}

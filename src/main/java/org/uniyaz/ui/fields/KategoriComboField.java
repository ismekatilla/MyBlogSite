package org.uniyaz.ui.fields;

import com.vaadin.ui.ComboBox;
import org.uniyaz.core.domain.Kategori;
import org.uniyaz.core.service.KategoriService;

import java.util.List;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class KategoriComboField extends ComboBox {
    private KategoriService kategoriService;

    public KategoriComboField() {
        this.kategoriService = new KategoriService();
        this.setDescription("Kategori Seçin !");
        fillComboBox();
    }

    public void fillComboBox() {
        this.removeAllItems();
        List<Kategori> kategoriList = kategoriService.kategoriListing();
        for (Kategori kategori : kategoriList) {
            this.addItem(kategori);
        }
    }

}

package org.uniyaz.ui.view;

import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import org.uniyaz.core.domain.Kategori;
import org.uniyaz.core.service.KategoriService;
import org.uniyaz.ui.components.MyContent;
import org.uniyaz.ui.fields.MakaleItemsGrid;
import org.uniyaz.ui.fields.MySidebarButton;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class SidebarPage extends VerticalLayout {
    private MyContent myContent;
    private KategoriService kategoriService = new KategoriService();


    public SidebarPage(MyContent myContent) {
        this.myContent = myContent;
        fillSidebar();
    }

    public void fillSidebar() {
        this.removeAllComponents();
        List<Kategori> kategoriList = new ArrayList<Kategori>();
        kategoriList = kategoriService.kategoriListing();
        for (Kategori kategori : kategoriList) {
            MySidebarButton mySidebarButton = new MySidebarButton(kategori.getAdi());
            mySidebarButton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {
                    MakaleItemsGrid makaleItemsGrid = new MakaleItemsGrid(kategori, myContent);
                    myContent.setContent(makaleItemsGrid);
                }
            });
            this.addComponent(mySidebarButton);
        }
    }

}

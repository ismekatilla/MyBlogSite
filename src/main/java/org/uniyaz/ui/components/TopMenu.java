package org.uniyaz.ui.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import org.uniyaz.core.domain.Kategori;
import org.uniyaz.ui.view.*;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class TopMenu extends HorizontalLayout {

    private MyContent myContent;
    private Sidebar sidebar;

    public TopMenu(MyContent myContent, Sidebar sidebar) {
        setSizeFull();
        buildMenuLayout();
        this.myContent = myContent;
        this.sidebar = sidebar;
    }

    private void buildMenuLayout() {
//        buildMakaleEkleButton();
//        buildMakaleListeleButton();
//        buildMakaleKategorisiEkleButton();
        buildMenuButtons();
    }

    private void buildMenuButtons() {
        MenuBar menuBar = new MenuBar();
        menuBar.setWidth(100.0f, Unit.PERCENTAGE);

        MenuBar.MenuItem categoryButton = menuBar.addItem("Kategori", null, null);
        kategoriEkle(categoryButton);
        kategoriSil(categoryButton);
        kategoriListele(categoryButton);

        MenuBar.MenuItem articleButton = menuBar.addItem("Makale", null, null);
        makaleEkle(articleButton);
        makaleListele(articleButton);

        addComponent(menuBar);
    }

    private void kategoriListele(MenuBar.MenuItem categoryButton) {

        categoryButton.addItem("Listele", FontAwesome.LIST, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                KategoriListelePage kategoriListelePage = new KategoriListelePage();
                myContent.setContent(kategoriListelePage);
            }
        });
    }


    //Makaleleri LİSTELE
    private void makaleListele(MenuBar.MenuItem articleButton) {
        MenuBar.MenuItem listMakaleButton = articleButton.addItem("Makaleleri Listele", FontAwesome.LIST, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                MakaleListingPage makaleListingPage = new MakaleListingPage();
                myContent.setContent(makaleListingPage);
            }
        });
    }

    //Makale Ekle
    private void makaleEkle(MenuBar.MenuItem articleButton) {
        MenuBar.MenuItem addArticleButton = articleButton.addItem("Makale Ekle", FontAwesome.PLUS, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                MakaleAddPage makaleAddPage = new MakaleAddPage();
                myContent.setContent(makaleAddPage);
            }
        });
    }

    //Kategori Ekle
    private void kategoriEkle(MenuBar.MenuItem categoryButton) {
        MenuBar.MenuItem addCategoryButton = categoryButton.addItem("Kategori Ekle", FontAwesome.PLUS, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                KategoriPage kategoriPage = new KategoriPage(new Kategori());
                myContent.setContent(kategoriPage);
            }
        });
    }

    //Kategori Sil
    private void kategoriSil(MenuBar.MenuItem categoryButton) {
        MenuBar.MenuItem deleteCategoryButton = categoryButton.addItem("Kategori Sil", FontAwesome.TRASH, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                KategoriDeletePage kategoriDeletePage = new KategoriDeletePage(sidebar);
                myContent.setContent(kategoriDeletePage);
            }
        });
    }

    private void buildMakaleKategorisiEkleButton() {
        Button makaleKategorisiEkleButton = new Button("Kategori Ekle");
        makaleKategorisiEkleButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
            }
        });
        makaleKategorisiEkleButton.setSizeUndefined();
        addComponent(makaleKategorisiEkleButton);
    }

    private void buildMakaleListeleButton() {
        Button makaleListeleButton = new Button("Makale Listele");
        makaleListeleButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

            }
        });
        makaleListeleButton.setSizeUndefined();
        addComponent(makaleListeleButton);
    }

    private void buildMakaleEkleButton() {
        Button makaleEkleButton = new Button("Makale Ekle");
        makaleEkleButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

            }
        });
        makaleEkleButton.setSizeUndefined();
        addComponent(makaleEkleButton);
    }
}

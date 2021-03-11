package org.uniyaz.core.domain;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class Kategori extends BaseDomain{

    private String adi;

    public Kategori() {
    }

    public Kategori(String adi) {
        this.adi = adi;
    }

    public Kategori(int id, String adi) {
        setId(id);
        this.adi= adi;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    @Override
    public String toString() {
        return adi;
    }
}
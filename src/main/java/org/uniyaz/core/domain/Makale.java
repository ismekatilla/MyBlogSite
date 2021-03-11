package org.uniyaz.core.domain;

import java.util.Date;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class Makale extends BaseDomain{
    private Integer id;
    private String baslik;
    private Date kayitTarihi;
    private String detay;
    private String yazar;
    private Integer id_kategori;

    public Makale(Integer id, String baslik, Date kayitTarihi, String detay, String yazar, Integer id_kategori) {
        this.id = id;
        this.baslik = baslik;
        this.kayitTarihi = kayitTarihi;
        this.detay = detay;
        this.yazar = yazar;
        this.id_kategori = id_kategori;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public Date getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(Date kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

    public String getDetay() {
        return detay;
    }

    public void setDetay(String detay) {
        this.detay = detay;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public Integer getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(Integer id_kategori) {
        this.id_kategori = id_kategori;
    }

    @Override
    public String toString() {
        return "Makale{" +
                "id=" + id +
                ", id_kategori=" + id_kategori +
                ", baslik='" + baslik + '\'' +
                ", kayitTarihi=" + kayitTarihi +
                ", detay='" + detay + '\'' +
                ", yazar='" + yazar + '\'' +
                '}';
    }
}

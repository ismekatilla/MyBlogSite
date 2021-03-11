package org.uniyaz.core.service;

import org.uniyaz.core.data.KategoriDao;
import org.uniyaz.core.domain.Kategori;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class KategoriService {
    KategoriDao kategoriDao=new KategoriDao();

    public void saveKategori(Kategori kategori){
        if (kategori != null && kategori.getId() != -1) kategoriDao.updateKategori(kategori);
        else kategoriDao.addKategori(kategori);
    }

    public List<Kategori> kategoriListing(){
        return kategoriDao.kategoriListing();
    }

    public void deleteKategori(Kategori kategori){
        kategoriDao.deleteKategori(kategori);
    }
}

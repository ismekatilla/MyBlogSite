package org.uniyaz.core.service;

import org.uniyaz.core.data.MakaleDao;
import org.uniyaz.core.domain.Kategori;
import org.uniyaz.core.domain.Makale;

import java.util.List;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class MakaleService {
    MakaleDao makaleDao = new MakaleDao();
    Kategori kategori;

    public void makaleEkle(Makale makale) {
        makaleDao.makaleEkle(makale);
    }

    public List<Makale> findAllMakale() {
        return makaleDao.findAllMakale();
    }

    public List<Makale> findAllMakaleByKategori(Kategori kategori){
        this.kategori = kategori;
        return makaleDao.findAllMakaleByKategori(kategori);
    }

    public void deleteMakale(Makale makale) {
        makaleDao.deleteMakale(makale);
    }
}

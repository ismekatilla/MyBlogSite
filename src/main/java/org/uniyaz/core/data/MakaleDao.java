package org.uniyaz.core.data;

import org.uniyaz.core.domain.Kategori;
import org.uniyaz.core.domain.Makale;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class MakaleDao {

    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Statement stmt = null;

    public void makaleEkle(Makale makale) {
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO deneme.makale (baslik,kayitTarihi,detay,yazar,id_kategori) VALUES (?,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, makale.getBaslik());
            ps.setObject(2, makale.getKayitTarihi());
            ps.setString(3, makale.getDetay());
            ps.setString(4, makale.getYazar());
            ps.setString(5, String.valueOf(makale.getId_kategori()));
            ps.executeUpdate();

        } catch (SQLException hata) {
            throw new RuntimeException(hata);
        } catch (ClassNotFoundException hata) {
            throw new RuntimeException(hata);
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public List<Makale> findAllMakale() {
        List<Makale> makaleList = new ArrayList<Makale>();
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM deneme.makale ORDER BY id ASC;";
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                makaleList.add(new Makale(
                        rs.getInt("id"),
                        rs.getString("baslik"),
                        rs.getDate("kayitTarihi"),
                        rs.getString("detay"),
                        rs.getString("yazar"),
                        rs.getInt("id_kategori")
                ));
            }
        } catch (SQLException hata) {
            throw new RuntimeException(hata);
        } catch (ClassNotFoundException hata) {
            throw new RuntimeException(hata);
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
        return makaleList;
    }

    public List<Makale> findAllMakaleByKategori(Kategori kategori) {
        List<Makale> filteredMakaleList = new ArrayList<Makale>();
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM deneme.makale WHERE id_kategori=? ORDER BY id ASC;";
            ps = connection.prepareStatement(sql);
            ps.setString(1, String.valueOf(kategori.getId()));
            rs = ps.executeQuery();
            while (rs.next()) {
                filteredMakaleList.add(new Makale(
                        rs.getInt("id"),
                        rs.getString("baslik"),
                        rs.getDate("kayitTarihi"),
                        rs.getString("detay"),
                        rs.getString("yazar"),
                        rs.getInt("id_kategori")
                ));
            }
        } catch (SQLException hata) {
            throw new RuntimeException(hata);
        } catch (ClassNotFoundException hata) {
            throw new RuntimeException(hata);
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
        return filteredMakaleList;
    }

    public void deleteMakale(Makale makale) {
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "DELETE FROM deneme.makale WHERE id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, makale.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package Model;

import Entity.TiketEntity;
import Helper.KoneksiDb;
import java.sql.*;
import java.util.ArrayList;

public class TiketModel {
 
    private String sql;
    public Connection conn = KoneksiDb.getconection();
    public ArrayList<TiketEntity> TiketEntity = new ArrayList<>();

    public TiketModel(){}
    
    public void insertData(TiketEntity tiket) {
        try {
            sql = "INSERT INTO tiket (film_kode,ruangan,mulai_film) Values(?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tiket.getFilm_kode());
            stat.setString(2, tiket.getRuangan());
            stat.setString(3, tiket.getMulai_film());

            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated !");
        } catch (SQLException e) {
            System.out.println("GAGAL INPUT DATA !!!");
            e.printStackTrace();
        }
    }
    public ArrayList<TiketEntity> getTiketEntity() {
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM tiket";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                TiketEntity tiket = new TiketEntity();
                tiket.setKode_tiket(rs.getInt("kode_tiket"));
                tiket.setFilm_kode(rs.getString("film_kode"));
                tiket.setRuangan(rs.getString("ruangan"));
                tiket.setMulai_film(rs.getString("mulai_film"));
                
                TiketEntity.add(tiket);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return TiketEntity;
    }
    public ArrayList<TiketEntity> showTiket(int kode_tiket) {
        try {
            sql = "SELECT * FROM tikt where kode_tiket = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, kode_tiket);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                 TiketEntity tiket = new TiketEntity();
                tiket.setKode_tiket(rs.getInt("kode_tiket"));
                tiket.setFilm_kode(rs.getString("film_kode"));
                tiket.setRuangan(rs.getString("ruangan"));
                tiket.setMulai_film(rs.getString("mulai_film"));
                
                TiketEntity.add(tiket);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return TiketEntity;
    }
    public ArrayList<TiketEntity> getDataTiket() {
        ArrayList<TiketEntity> arraylisttiket = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT tiket.kode_tiket,film.judul,tiket.ruangan,tiket.mulai_film FROM tiket "
                    + "inner join film on (film.kode_film = tiket.film_kode)";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                TiketEntity tiket = new TiketEntity();
                tiket.setKode_tiket(rs.getInt("kode_tiket"));
                tiket.setFilm_kode(rs.getString("judul"));
                tiket.setRuangan(rs.getString("ruangan"));
                tiket.setMulai_film(rs.getString("mulai_film"));
                
                arraylisttiket.add(tiket);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylisttiket; //mengembalikan kumpulandata yg  didpt kedlm arraylisttrx
    }
    public void deleteData(int kode_tiket) {
        try {
            sql = "DELETE FROM tiket where kode_tiket =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, kode_tiket);
            stat.executeUpdate();
        } catch (SQLException e) {
            System.out.println("GAGAL Hapus DATA!!!");
        }
    }
}

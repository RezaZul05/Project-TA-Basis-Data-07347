package Model;

import Entity.FilmEntity;
import Helper.KoneksiDb;
import java.sql.*;
import java.util.ArrayList;

public class FilmModel {

    private String sql;
    public Connection conn = KoneksiDb.getconection();
    public ArrayList<FilmEntity> FilmEntity = new ArrayList<>();

    public FilmModel() {
    }

    public void insertData(FilmEntity film) {
        try {
            sql = "INSERT INTO film (kode_film,judul,durasi,harga) Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, film.getKode_film());
            stat.setString(2, film.getJudul());
            stat.setString(3, film.getDurasi());
            stat.setString(4, film.getHarga());

            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated !");
        } catch (SQLException e) {
            System.out.println("GAGAL INPUT DATA !!!");
            e.printStackTrace();
        }
    }

    public ArrayList<FilmEntity> getFilmEntity(String kode_film) {
        try {
            sql = "SELECT * FROM pembeli where id_pembeli = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, kode_film);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                FilmEntity film = new FilmEntity();
                film.setKode_film(rs.getString("kode_film"));
                film.setJudul(rs.getString("judul"));
                film.setDurasi(rs.getString("durasi"));
                film.setHarga(rs.getString("harga"));

                FilmEntity.add(film);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return FilmEntity;
    }

    public void deleteData(String kode_film) {
        try {
            sql = "DELETE FROM film where kode_film =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, kode_film);
            stat.executeUpdate();
        } catch (SQLException e) {
            System.out.println("GAGAL Hapus DATA!!!");
        }
    }

    public ArrayList<FilmEntity> getDataTambahFilm() {
        ArrayList<FilmEntity> arraylistfilm = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM film, tiket WHERE film.kode_film = tiket.film_kode";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                FilmEntity film = new FilmEntity();
                film.setKode_film(rs.getString("kode_film"));
                film.setJudul(rs.getString("judul"));
                film.setDurasi(rs.getString("durasi"));
                film.setHarga(rs.getString("harga"));
                film.kode_tiket = rs.getInt("kode_tiket");

                arraylistfilm.add(film);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistfilm; //mengembalikan kumpulandata yg  didpt kedlm arraylisttrx
    }

    public ArrayList<FilmEntity> getfilm() {
        ArrayList<FilmEntity> arraylistfilm = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM film";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                FilmEntity film = new FilmEntity();
                film.setKode_film(rs.getString("kode_film"));
                film.setJudul(rs.getString("judul"));
                film.setDurasi(rs.getString("durasi"));
                film.setHarga(rs.getString("harga"));

                arraylistfilm.add(film);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistfilm; //mengembalikan kumpulandata yg  didpt kedlm arraylisttrx
    }
}

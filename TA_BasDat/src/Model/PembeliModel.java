package Model;

import Entity.PembeliEntity;
import Helper.KoneksiDb;
import java.sql.*;
import java.util.ArrayList;

public class PembeliModel {
     private String sql;
    public Connection conn = KoneksiDb.getconection();
    public ArrayList<PembeliEntity> PembeliEntity = new ArrayList<>();
    
    public PembeliModel(){}
    
     
     public void insertData(PembeliEntity PembeliEntity) {
        try {
            sql = "INSERT INTO pembeli (id_pembeli, nama_pembeli, no_telp) Values(?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, PembeliEntity.getId_pembeli());
            stat.setString(2, PembeliEntity.getNama_pembeli());
            stat.setString(3, PembeliEntity.getNo_telp());

            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated !");
        } catch (SQLException e) {
            System.out.println("GAGAL INPUT DATA !!!");
            e.printStackTrace();
        }
    }
     public ArrayList<PembeliEntity> showPembeli(int id_pembeli) {
        try {
            sql = "SELECT * FROM pembeli WHERE id_pembeli = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id_pembeli);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                PembeliEntity pembeli = new PembeliEntity();
                pembeli.setId_pembeli(rs.getInt("id_pembeli"));
                pembeli.setNama_pembeli(rs.getString("nama_pembeli"));
                pembeli.setNo_telp(rs.getString("no_telp"));
                PembeliEntity.add(pembeli);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return PembeliEntity;
    }
     public ArrayList<PembeliEntity> getData() {
        ArrayList<PembeliEntity> arraylistpembeli = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM pembeli";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                PembeliEntity pembeli = new PembeliEntity();
                pembeli.setId_pembeli(rs.getInt("id_pembeli"));
                pembeli.setNama_pembeli(rs.getString("nama_pembeli"));
                pembeli.setNo_telp(rs.getString("no_telp"));                
                arraylistpembeli.add(pembeli);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistpembeli; //mengembalikan kumpulandata yg  didpt kedlm arraylisttrx
    }
}

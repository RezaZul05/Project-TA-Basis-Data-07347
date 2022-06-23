package Model;

import Entity.TransaksiEntity;
import Entity.TransaksiJoin;
import Helper.KoneksiDb;
import java.sql.*;
import java.util.ArrayList;

public class TransaksiModel {
     private String sql;
    public Connection conn = KoneksiDb.getconection();
    public ArrayList<TransaksiEntity> transaksiEntity = new ArrayList<>();

    public TransaksiModel(){}
    
    public void insertData(TransaksiEntity transaksi) {
        try {
            sql = "INSERT INTO transaksi (pembeli_id,operator_id,tgl_pesan,banyak,total_harga) Values(?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, transaksi.getPembeli_id());
            stat.setInt(2, transaksi.getOperator_id());
            stat.setString(3, transaksi.getTgl_pesan());
            stat.setInt(4, transaksi.getBanyak());
            stat.setInt(5, transaksi.getTotal_harga());

            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated !");
        } catch (SQLException e) {
            System.out.println("GAGAL INPUT DATA !!!");
            e.printStackTrace();
        }
    }
    public ArrayList<TransaksiEntity> showTransaksi(int id_transaksi) {
        try {
            sql = "SELECT * FROM admin where id_transasksi = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id_transaksi);
            ResultSet rs = stat.executeQuery();
            TransaksiEntity transaksi = new TransaksiEntity();
            if (rs.next()) {
                transaksi.setId_transaksi(rs.getInt("id_transaksi"));
                transaksi.setPembeli_id(rs.getInt("pembeli_id"));
                transaksi.setOperator_id(rs.getInt("operator_id"));
                transaksi.setTgl_pesan(rs.getString("tgl_pesan"));
                transaksi.setBanyak(rs.getInt("banyak"));
                transaksi.setTotal_harga(rs.getInt("total_harga"));
                transaksiEntity.add(transaksi);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return transaksiEntity;
    }
    public ArrayList<TransaksiJoin> getData() {
        ArrayList<TransaksiJoin> arraylisttransaksi = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT transaksi.id_transaksi, operator.nama_operator 'nama_operator', pembeli.nama_pembeli 'nama_pembeli', transaksi.tgl_pesan, transaksi.banyak, transaksi.total_harga FROM transaksi inner join pembeli on (pembeli.id_pembeli = transaksi.pembeli_id) inner join operator on (operator.id_operator = transaksi.operator_id)";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id_transaksi"));
                TransaksiJoin transaksi = new TransaksiJoin();
                transaksi.id = (rs.getInt("id_transaksi"));
                transaksi.nama_opeator = (rs.getString("nama_operator"));
                transaksi.nama_pembeli = (rs.getString("nama_pembeli"));
                transaksi.tgl = (rs.getString("tgl_pesan"));
                transaksi.banyak = (rs.getInt("banyak"));
                transaksi.total = (rs.getInt("total_harga"));
                
                arraylisttransaksi.add(transaksi);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylisttransaksi; //mengembalikan kumpulandata yg  didpt kedlm arraylisttrx
    }
    
}

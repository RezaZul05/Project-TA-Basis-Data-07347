package Model;

import Entity.detail_trxJoin;
import Entity.Detail_TrxEntity;
import Helper.KoneksiDb;
import java.sql.*;
import java.util.ArrayList;

public class Detail_TrxModel {
    private String sql;
    public Connection conn = KoneksiDb.getconection();
    public ArrayList<detail_trxJoin> Detail_TrxEntity = new ArrayList<>();

    public Detail_TrxModel(){}
    public ArrayList<detail_trxJoin> getDetail_Trx(){
        ArrayList<detail_trxJoin> arraylistdetailTrx = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = " SELECT transaksi.id_transaksi,transaksi.operator_id,transaksi.pembeli_id,transaksi.tgl_pesan,transaksi.banyak,transaksi.total_harga,tiket.film_kode,tiket.ruangan,tiket.mulai_film FROM detail_transaksi inner join transaksi on (transaksi.id_transaksi = detail_transaksi.transaksi_id) inner join tiket on (tiket.kode_tiket = detail_transaksi.tiket_kode)";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
               System.out.println(rs.getInt("id_transaksi"));
                detail_trxJoin detail_Trx = new detail_trxJoin();
                detail_Trx.id_transaksi = (rs.getInt("id_transaksi"));
                detail_Trx.opeator_id = (rs.getString("operator_id"));
                detail_Trx.pembeli_id = (rs.getString("pembeli_id"));
                detail_Trx.tgl = (rs.getString("tgl_pesan"));
                detail_Trx.banyak = (rs.getInt("banyak"));
                detail_Trx.total = (rs.getInt("total_harga"));
                detail_Trx.film_kode = (rs.getString("film_kode"));
                detail_Trx.ruangan = (rs.getString("ruangan"));
                detail_Trx.mulai_film = (rs.getString("mulai_film"));
                
                arraylistdetailTrx.add(detail_Trx);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistdetailTrx; //mengembalikan kumpulandata yg  didpt kedlm arraylisttrx
    }
    public void insertData(Detail_TrxEntity detaiTrx) {
        try {
            sql = "INSERT INTO detail_transaksi (transaksi_id,tiket_kode) Values(?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, detaiTrx.getTransaksi_id());
            stat.setInt(2, detaiTrx.getTiket_kode());

            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated !");
        } catch (SQLException e) {
            System.out.println("GAGAL INPUT DATA !!!");
            e.printStackTrace();
        }
    }
    public void deleteData(int transaksi_id) {
        try {
            sql = "DELETE FROM detail_transaksi where transaksi_id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, transaksi_id);
            stat.executeUpdate();
        } catch (SQLException e) {
            System.out.println("GAGAL Hapus DATA!!!");
        }
    }
}

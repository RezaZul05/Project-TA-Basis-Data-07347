/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.OperatorEntity;
import Helper.KoneksiDb;
import java.sql.*;
import java.util.ArrayList;

public class OperatorModel {
    private String sql;
    public Connection conn = KoneksiDb.getconection();
    public ArrayList<OperatorEntity> OperatorEntity = new ArrayList<>();

    public OperatorModel() {
    }

    public void insertData(OperatorEntity operator) {
        try {
            sql = "INSERT INTO operator (id_operator,nama_operator,alamat_operator) Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt   (1, operator.getId_operator());
            stat.setString(2, operator.getNama_operator());
            stat.setString(3, operator.getAlamat_operator());

            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated !");
        } catch (SQLException e) {
            System.out.println("GAGAL INPUT DATA !!!");
            e.printStackTrace();
        }
    }
    public int cekData(int id_operator, String nama_operator) {
        int cek = 0;
        try {
            sql = "SELECT *FROM operator where id_operator = ? and nama_operator = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id_operator);
            stat.setString(2, nama_operator);
            ResultSet rs = stat.executeQuery();
            if (rs.next()) {
                cek = rs.getInt("id_operator");

            } else {
                cek = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cek;
    }
    public ArrayList<OperatorEntity> showOperator(int id_operator) {
        try {
            sql = "SELECT * FROM admin where id_operator = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id_operator);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                OperatorEntity operator = new OperatorEntity();
                operator.setId_operator(rs.getInt("id_operator"));
                operator.setNama_operator(rs.getString("nama_operator"));
                operator.setAlamat_operator(rs.getString("alamat_operator"));
                
                OperatorEntity.add(operator);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return OperatorEntity;
    }
    public ArrayList<OperatorEntity> getOperatorEntity() {
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM operator";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                OperatorEntity operator = new OperatorEntity();
                operator.setId_operator(rs.getInt("id_operator"));
                operator.setNama_operator(rs.getString("nama_operator"));
                operator.setAlamat_operator(rs.getString("alamat_operator"));
                
                OperatorEntity.add(operator);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return OperatorEntity;
    }
    public void deleteOperator(int id_operator) {
        try {
            sql = "DELETE FROM operator where id_operator =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id_operator);
            stat.executeUpdate();
        } catch (SQLException e) {
            System.out.println("GAGAL Hapus DATA!!!");
        }
    }
    
    public void saveTransaksi(int id_pem, int id_op, int banyak, int harga, String id_film)
    {
        try{
           
            PreparedStatement stat = conn.prepareStatement("INSERT INTO transaksi(pembeli_id, operator_id, banyak, total_harga)"
                    + " VALUES (?, ?, ?, ? )");
            stat.setInt(1, id_pem);
            stat.setInt(2, id_op);
            stat.setInt(3, banyak);
            stat.setInt(4, harga);
            
            stat.executeUpdate();

                    
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}

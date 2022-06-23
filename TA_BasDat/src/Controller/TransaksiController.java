/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Entity.*;
import Model.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class TransaksiController {
    
    public void insertData(int pembeli_id, int operator_id, String tgl_pesan, int banyak, int total_harga){
        ObjectModelController.transaksi.insertData(new TransaksiEntity(pembeli_id,operator_id,tgl_pesan,banyak,total_harga));
    }
    public ArrayList <TransaksiEntity>  showTransaksi(int id_transaksi){
        return ObjectModelController.transaksi.showTransaksi(id_transaksi);
    }
     public ArrayList <TransaksiJoin> getTransaksiEntity()
    {
        return ObjectModelController.transaksi.getData();
    }
     public DefaultTableModel dataTransaksi() {
        DefaultTableModel dataDaftarTransaksi = new DefaultTableModel();
        Object[] kolom = {"KODE TRANSAKSI", "NAMA OPERATOR", "NAMA PEMBELI", "TGL PESAN", "BANYAK", "TOTAL HARGA"};
        dataDaftarTransaksi.setColumnIdentifiers(kolom);
        int size = getTransaksiEntity().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[6];
            data[0] = ObjectModelController.transaksi.getData().get(i).id;
            data[1] = ObjectModelController.transaksi.getData().get(i).nama_opeator;
            data[2] = ObjectModelController.transaksi.getData().get(i).nama_pembeli;
            data[3] = ObjectModelController.transaksi.getData().get(i).tgl;
            data[4] = ObjectModelController.transaksi.getData().get(i).banyak;
            data[5] = ObjectModelController.transaksi.getData().get(i).total;
            dataDaftarTransaksi.addRow(data);
        }
        return dataDaftarTransaksi;
    }
    
}

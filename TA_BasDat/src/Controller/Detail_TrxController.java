package Controller;

import Entity.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Detail_TrxController {
    
    
     public ArrayList <detail_trxJoin> getDetail_TrxEntity()
    {
        return ObjectModelController.detail_Trx.getDetail_Trx();
    }
     public void insertData(int transaksi_id, int tiket_kode){
        ObjectModelController.detail_Trx.insertData(new Detail_TrxEntity(transaksi_id, tiket_kode));
    }
     public DefaultTableModel dataDetail_Trx() {
        DefaultTableModel datadetail_trx = new DefaultTableModel();
        Object[] kolom = {"KODE TRANSAKSI", "ID OPERATOR", "ID PEMBELI", "TGL PESAN","BANYAK","TOTAL HARGA","KODE FILM","RUANGAN","MULAI_FILM"};
        datadetail_trx.setColumnIdentifiers(kolom);
        int size = getDetail_TrxEntity().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[9];
            data[0] = ObjectModelController.detail_Trx.getDetail_Trx().get(i).id_transaksi;
            data[1] = ObjectModelController.detail_Trx.getDetail_Trx().get(i).opeator_id;
            data[2] = ObjectModelController.detail_Trx.getDetail_Trx().get(i).pembeli_id;
            data[3] = ObjectModelController.detail_Trx.getDetail_Trx().get(i).tgl;
            data[4] = ObjectModelController.detail_Trx.getDetail_Trx().get(i).banyak;
            data[5] = ObjectModelController.detail_Trx.getDetail_Trx().get(i).total;
            data[6] = ObjectModelController.detail_Trx.getDetail_Trx().get(i).film_kode;
            data[7] = ObjectModelController.detail_Trx.getDetail_Trx().get(i).ruangan;
            data[8] = ObjectModelController.detail_Trx.getDetail_Trx().get(i).mulai_film;
            
            datadetail_trx.addRow(data);
        }
        return datadetail_trx;
    }
     public void deleteDetailTrx(int transaksi_id)
    {
        ObjectModelController.detail_Trx.deleteData(transaksi_id);
    }
     
}

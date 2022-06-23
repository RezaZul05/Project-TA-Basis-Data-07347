package Controller;

import Entity.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class PembeliController {
    
    public void insertDataPembeli(int id_pembeli, String nama_pembeli, String no_telp){
        ObjectModelController.pembeli.insertData(new PembeliEntity(id_pembeli,nama_pembeli,no_telp));
    }
    public void insertDataPembeli2(int id_pembeli, String nama_pembeli, String no_telp){
        PembeliEntity pembeli = new PembeliEntity();
        pembeli.setId_pembeli(id_pembeli);
        pembeli.setNama_pembeli(nama_pembeli);
        pembeli.setNo_telp(no_telp);
        ObjectModelController.pembeli.insertData(pembeli);
    }
    public ArrayList <PembeliEntity>  showDataPembeliEntity(int id_pembeli){
        return ObjectModelController.pembeli.showPembeli(id_pembeli);
    }
     public ArrayList <PembeliEntity> getPembeliEntity()
    {
        return ObjectModelController.pembeli.getData();
    }
      public DefaultTableModel dataPembeli() {
        DefaultTableModel datapembeli = new DefaultTableModel();
        Object[] kolom = {"ID PEMBELI", "NAMA PEMBELI", "NO TELP"};
        datapembeli.setColumnIdentifiers(kolom);
        int size = getPembeliEntity().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[6];
            data[0] = ObjectModelController.pembeli.getData().get(i).getId_pembeli();
            data[1] = ObjectModelController.pembeli.getData().get(i).getNama_pembeli();
            data[2] = ObjectModelController.pembeli.getData().get(i).getNo_telp();
            datapembeli.addRow(data);
        }
        return datapembeli;
    }
}

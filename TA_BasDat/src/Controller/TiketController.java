/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class TiketController {
    
    public void insertData(String film_kode, String ruangan, String mulai_film){
        ObjectModelController.tiket.insertData(new TiketEntity(film_kode,ruangan,mulai_film));
    }
     public ArrayList <TiketEntity>  showTiket(int kode_tiket){
        return ObjectModelController.tiket.showTiket(kode_tiket);
    }
     public ArrayList <TiketEntity> getTiketEntity()
    {
        return ObjectModelController.tiket.getDataTiket();
    }
     public DefaultTableModel dataTiket() {
        DefaultTableModel datatiket = new DefaultTableModel();
        Object[] kolom = {"KODE TIKET", "JUDUL FILM", "RUANGAN", "MULAI FILM"};
        datatiket.setColumnIdentifiers(kolom);
        int size = getTiketEntity().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[6];
            data[0] = ObjectModelController.tiket.getDataTiket().get(i).getKode_tiket();
            data[1] = ObjectModelController.tiket.getDataTiket().get(i).getFilm_kode();
            data[2] = ObjectModelController.tiket.getDataTiket().get(i).getRuangan();
            data[3] = ObjectModelController.tiket.getDataTiket().get(i).getMulai_film();
            datatiket.addRow(data);
        }
        return datatiket;
    }
     public void deleteFilm(int kode_tiket)
    {
        ObjectModelController.tiket.deleteData(kode_tiket);
    }
}

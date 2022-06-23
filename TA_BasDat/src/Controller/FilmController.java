package Controller;

import Entity.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class FilmController {
    
    public FilmController() {}
    
    public void insertFilm(String kode_film, String judul, String durasi, String harga){
        ObjectModelController.film.insertData(new FilmEntity(kode_film,judul,durasi,harga));
    }
    public void insertFilm2(String kode_film, String judul, String durasi, String harga){
        FilmEntity film = new FilmEntity();
        film.setKode_film(kode_film);
        film.setJudul(judul);
        film.setDurasi(durasi);
        film.setHarga(harga);
        ObjectModelController.film.insertData(film);
    }
    public ArrayList <FilmEntity> getFilmEntity()
    {
        return ObjectModelController.film.getfilm();
    }
    public void deleteFilm(String kode_film)
    {
        ObjectModelController.film.deleteData(kode_film);
    }
//     public DefaultTableModel dataFilm() {
//        DefaultTableModel dataDaftarFilm = new DefaultTableModel();
//        Object[] kolom = {"KODE TIKET", "KODE FILM", "JUDUL", "DURASI", "HARGA"};
//        dataDaftarFilm.setColumnIdentifiers(kolom);
//        int size = getFilmEntity().size();
//        for (int i = 0; i < size; i++) {
//            Object[] data = new Object[5];
//            data[0] = ObjectModelController.film.getDataTambahFilm().get(i).kode_tiket;
//            data[1] = ObjectModelController.film.getDataTambahFilm().get(i).getKode_film();
//            data[2] = ObjectModelController.film.getDataTambahFilm().get(i).getJudul();
//            data[3] = ObjectModelController.film.getDataTambahFilm().get(i).getDurasi();
//            data[4] = ObjectModelController.film.getDataTambahFilm().get(i).getHarga();
//            dataDaftarFilm.addRow(data);
//        }
//        return dataDaftarFilm;
//    }
     public DefaultTableModel viewFilm() {
        DefaultTableModel dataDaftarFilm = new DefaultTableModel();
        Object[] kolom = {"KODE FILM", "JUDUL", "DURASI", "HARGA"};
        dataDaftarFilm.setColumnIdentifiers(kolom);
        int size = getFilmEntity().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[4];
            data[0] = ObjectModelController.film.getfilm().get(i).getKode_film();
            data[1] = ObjectModelController.film.getfilm().get(i).getJudul();
            data[2] = ObjectModelController.film.getfilm().get(i).getDurasi();
            data[3] = ObjectModelController.film.getfilm().get(i).getHarga();
            dataDaftarFilm.addRow(data);
        }
        return dataDaftarFilm;
    }
}

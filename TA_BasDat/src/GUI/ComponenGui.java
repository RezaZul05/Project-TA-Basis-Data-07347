package GUI;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class ComponenGui extends JFrame {

    protected JButton btntransaksi = new JButton("TRANSAKSI");
    protected JButton btnadmin = new JButton("VIA ADMIN");
    protected JButton btnpembeli = new JButton("DATA PEMBELI");
    protected JButton btntambah = new JButton("Tambah Data Transaksi");
    protected JButton btnview = new JButton("View Data Transaksi");
    protected JButton btnmasuk = new JButton("Masuk");
    protected JButton btnhapusfilm = new JButton("DELETE FILM");
    protected JButton btntambahTransaksi = new JButton("TAMBAH TRANSAKSI");
    protected JButton btnviewadmin = new JButton("LIHAT DATA ADMIN");
    protected JButton btntambahdetailtrx = new JButton("TAMBAH DETAIL TRX");
    protected JButton btnfilm = new JButton("DATA FILM");
    protected JButton btntambahfilm = new JButton("TAMBAH FILM");
    protected JButton btntambahpembeli = new JButton("TAMBAH DATA");
    protected JButton btnaddfilm = new JButton("ADD FILM");
    protected JButton btnviewpembeli = new JButton("LIHAT DATA PEMBELI");
    protected JButton btnkeluar = new JButton("KELUAR");
    protected JButton btnback = new JButton("<< BACK");
    protected JButton btnlama = new JButton("PEMBELI LAMA");
    protected JButton btnbaru = new JButton("PEMBELI BARU");
    protected JButton btnpilih = new JButton("PILIH PEMBELI");
    

    protected JLabel labelmenu = new JLabel("MENU UTAMA");
    protected JLabel labeltransaksi = new JLabel("TRANSAKSI");
    protected JLabel labeltambahdata = new JLabel("TAMBAH DATA");
    protected JLabel labelviewtrx = new JLabel("LIHAT DATA TRANSAKSI");
    protected JLabel labelbeli = new JLabel("BELI PRODUK");
    protected JLabel labelviaadmin = new JLabel("VIA ADMIN");
    protected JLabel labelmenuadmin = new JLabel("MENU ADMIN");
    protected JLabel labelviewadmin = new JLabel("VIEW DATA ADMIN");
    protected JLabel labelupdate = new JLabel("UPDATE NAMA AKUN");
    protected JLabel labeldelete = new JLabel("DELETE DATTA");
    protected JLabel labeltambahpemeli = new JLabel("TAMBAH DATA");
    protected JLabel labeldurasi = new JLabel("Durasi");
    protected JLabel labeljudul = new JLabel("Judul");
    protected JLabel labelviewpembeli = new JLabel("LIHAT DATA PEMBELI");
    protected JLabel labelkodefilm = new JLabel("Kode");
    protected JLabel labelid = new JLabel("ID");
    protected JLabel labelidgame = new JLabel("MASUKKAN ID GAME");
    protected JLabel labelpw = new JLabel("MASUKKAN PASSWORD");
    protected JLabel labelnama = new JLabel("NAMA");
    protected JLabel labelnotelp = new JLabel("NO.TELP");
    protected JLabel labelakun = new JLabel("NAMA AKUN");
    protected JLabel labelproduk = new JLabel("NAMA PRODUK");
    protected JLabel labelnominal = new JLabel("NOMINAL");
    protected JLabel labelhargafilm = new JLabel("Harga");
    protected JLabel labelnotrx = new JLabel("MASUKKAN NOMOR TRANSAKSI");
    protected JLabel labeljumlahtiket = new JLabel("Jumlah");
    protected JLabel labeldeltrx = new JLabel("MASUKKAN NOMOR TRANSAKSI YANG AKAN DIHAPUS");
    protected JLabel labelidoperator = new JLabel("ID ");
    protected JLabel labelnama_operator = new JLabel("NAMA");
    protected JLabel bingkaigambar = new JLabel();

    protected JTextField fieldtrx = new JTextField();
    protected JTextField fieldidpembeli = new JTextField();
    protected JTextField fieldkodefilm = new JTextField();
    protected JTextField fieldnama = new JTextField();
    protected JTextField fieldjudul = new JTextField();
    protected JTextField fieldnotelp = new JTextField();
    protected JTextField fielddurasi = new JTextField();
    protected JTextField fieldproduk = new JTextField();
    protected JTextField fieldnominal = new JTextField();
    protected JTextField fieldhargafilm = new JTextField();
    protected JTextField fieldnotrx = new JTextField();
    protected JTextField fieldakunbaru = new JTextField();
    protected JTextField fielddeltrx = new JTextField();
    protected JTextField fieldidoperator = new JTextField();
    protected JTextField fieldnama_operator = new JTextField();
    protected JTextField fieldjumlahtiket = new JTextField();
    BufferedImage bufferedImage = null;
    Image gambarresize;

    void kosong() {
        fieldtrx.setText(null);
        fieldidpembeli.setText(null);
        fieldjudul.setText(null);
        fieldnama.setText(null);
        fieldkodefilm.setText(null);
        fieldnotelp.setText(null);
        fielddurasi.setText(null);
        fieldproduk.setText(null);
        fieldnominal.setText(null);
        fieldhargafilm.setText(null);
        fieldnotrx.setText(null);
        fieldakunbaru.setText(null);
        fielddeltrx.setText(null);
        fieldidoperator.setText(null);
        fieldnama_operator.setText(null);

    }
}



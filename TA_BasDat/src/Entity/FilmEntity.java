package Entity;

public class FilmEntity {
    protected String kode_film, judul, durasi, harga;
    public int kode_tiket;

    public FilmEntity(String kode_film, String judul, String durasi, String harga) {
        this.kode_film = kode_film;
        this.judul = judul;
        this.durasi = durasi;
        this.harga = harga;
    }
    
    public FilmEntity(){}

    public String getHarga() {
        return harga;
    }

    public String getKode_film() {
        return kode_film;
    }

    public String getJudul() {
        return judul;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public void setKode_film(String kode_film) {
        this.kode_film = kode_film;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }
}

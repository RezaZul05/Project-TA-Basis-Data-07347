package Entity;

public class TiketEntity {
    protected int kode_tiket;
    protected String film_kode, ruangan, mulai_film;
    
    public TiketEntity(){}

    public TiketEntity(int kode_tiket, String film_kode, String ruangan, String mulai_film) {
        this.kode_tiket = kode_tiket;
        this.film_kode = film_kode;
        this.ruangan = ruangan;
        this.mulai_film = mulai_film;
    }
    
    public TiketEntity( String film_kode, String ruangan, String mulai_film) {
        this.film_kode = film_kode;
        this.ruangan = ruangan;
        this.mulai_film = mulai_film;
    }
    
    public int getKode_tiket() {
        return kode_tiket;
    }

    public String getFilm_kode() {
        return film_kode;
    }

    public String getRuangan() {
        return ruangan;
    }

    public String getMulai_film() {
        return mulai_film;
    }

    public void setKode_tiket(int kode_tiket) {
        this.kode_tiket = kode_tiket;
    }

    public void setFilm_kode(String film_kode) {
        this.film_kode = film_kode;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public void setMulai_film(String mulai_film) {
        this.mulai_film = mulai_film;
    }
    
    
}

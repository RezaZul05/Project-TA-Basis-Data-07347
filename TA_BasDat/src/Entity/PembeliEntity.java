package Entity;

public class PembeliEntity {
    protected int id_pembeli;
    protected String nama_pembeli, no_telp;
    
    public PembeliEntity(){}

    public PembeliEntity(int id_pembeli, String nama_pembeli, String no_telp) {
        this.id_pembeli = id_pembeli;
        this.nama_pembeli = nama_pembeli;
        this.no_telp = no_telp;
    }

    public int getId_pembeli() {
        return id_pembeli;
    }

    public String getNama_pembeli() {
        return nama_pembeli;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setId_pembeli(int id_pembeli) {
        this.id_pembeli = id_pembeli;
    }

    public void setNama_pembeli(String nama_pembeli) {
        this.nama_pembeli = nama_pembeli;
    }
    
    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
}

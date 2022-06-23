package Entity;

public class TransaksiEntity {
    protected int id_transaksi, pembeli_id, operator_id;
    protected String tgl_pesan;
    protected int banyak, total_harga;
    
    public TransaksiEntity(){}

    public TransaksiEntity(int id_transaksi, int pembeli_id, int operator_id, String tgl_pesan, int banyak, int total_harga) {
        this.id_transaksi = id_transaksi;
        this.pembeli_id = pembeli_id;
        this.operator_id = operator_id;
        this.tgl_pesan = tgl_pesan;
        this.banyak = banyak;
        this.total_harga = total_harga;
    }

    public TransaksiEntity(int pembeli_id, int operator_id, String tgl_pesan, int banyak, int total_harga) {
        this.pembeli_id = pembeli_id;
        this.operator_id = operator_id;
        this.tgl_pesan = tgl_pesan;
        this.banyak = banyak;
        this.total_harga = total_harga;
    }
    

    

    public int getId_transaksi() {
        return id_transaksi;
    }

    public int getPembeli_id() {
        return pembeli_id;
    }

    public int getOperator_id() {
        return operator_id;
    }

    public int getBanyak() {
        return banyak;
    }

    public int getTotal_harga() {
        return total_harga;
    }

    public String getTgl_pesan() {
        return tgl_pesan;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public void setPembeli_id(int pembeli_id) {
        this.pembeli_id = pembeli_id;
    }

    public void setOperator_id(int operator_id) {
        this.operator_id = operator_id;
    }

    public void setBanyak(int banyak) {
        this.banyak = banyak;
    }

    public void setTotal_harga(int total_harga) {
        this.total_harga = total_harga;
    }

    public void setTgl_pesan(String tgl_pesan) {
        this.tgl_pesan = tgl_pesan;
    }  
}

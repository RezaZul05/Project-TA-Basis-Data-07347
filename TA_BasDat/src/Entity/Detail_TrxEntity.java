package Entity;

public class Detail_TrxEntity {
    protected int transaksi_id, tiket_kode;
    
    public Detail_TrxEntity(){}

    public Detail_TrxEntity(int transaksi_id, int tiket_kode) {
        this.transaksi_id = transaksi_id;
        this.tiket_kode = tiket_kode;
    }

    public int getTransaksi_id() {
        return transaksi_id;
    }

    public int getTiket_kode() {
        return tiket_kode;
    }

    public void setTransaksi_id(int transaksi_id) {
        this.transaksi_id = transaksi_id;
    }

    public void setTiket_kode(int tiket_kode) {
        this.tiket_kode = tiket_kode;
    }
    
}

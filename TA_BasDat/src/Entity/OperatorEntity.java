package Entity;

public class OperatorEntity {
    protected int id_operator;
    protected String nama_operator, alamat_operator;
    
    public OperatorEntity(){}

    public OperatorEntity(int id_operator, String nama_operator, String alamat_operator) {
        this.id_operator = id_operator;
        this.nama_operator = nama_operator;
        this.alamat_operator = alamat_operator;
    }

    public int getId_operator() {
        return id_operator;
    }

    public String getNama_operator() {
        return nama_operator;
    }

    public String getAlamat_operator() {
        return alamat_operator;
    }

    public void setId_operator(int id_operator) {
        this.id_operator = id_operator;
    }

    public void setNama_operator(String nama_operator) {
        this.nama_operator = nama_operator;
    }

    public void setAlamat_operator(String alamat_operator) {
        this.alamat_operator = alamat_operator;
    }
}

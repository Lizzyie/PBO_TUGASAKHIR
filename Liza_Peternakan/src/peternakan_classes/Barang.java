package peternakan_classes;

public class Barang {
     int id;
     String namaBarang;
     int stok;
     String satuan;
     String jenis;

    public Barang(int id, String namaBarang, int stok, String satuan, String jenis) {
        this.id = id;
        this.namaBarang = namaBarang;
        this.stok = stok;
        this.satuan = satuan;
        this.jenis = jenis;
    }

    public int getId() {
        return id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public int getStok() {
        return stok;
    }

    public String getSatuan() {
        return satuan;
    }

    public String getJenis() {
        return jenis;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    @Override
    public String toString() {
        return "Barang{" +
                "id=" + id +
                ", namaBarang='" + namaBarang + '\'' +
                ", stok=" + stok +
                ", satuan='" + satuan + '\'' +
                ", jenis='" + jenis + '\'' +
                '}';
    }
}

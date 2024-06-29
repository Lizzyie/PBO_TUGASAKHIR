package peternakan_classes;

import java.util.Date;

public class CatatanKeuangan {
     int id;
     Date tanggal;
     double pengeluaran;
     double harga;
     String keterangan;

    public CatatanKeuangan(int id, Date tanggal, double pengeluaran, double harga, String keterangan) {
        this.id = id;
        this.tanggal = tanggal;
        this.pengeluaran = pengeluaran;
        this.harga = harga;
        this.keterangan = keterangan;
    }

    public int getId() {
        return id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public double getPengeluaran() {
        return pengeluaran;
    }

    public double getHarga() {
        return harga;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public void setPengeluaran(double pengeluaran) {
        this.pengeluaran = pengeluaran;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public String toString() {
        return "CatatanKeuangan{" +
                "id=" + id +
                ", tanggal=" + tanggal +
                ", pengeluaran=" + pengeluaran +
                ", harga=" + harga +
                ", keterangan='" + keterangan + '\'' +
                '}';
    }
}

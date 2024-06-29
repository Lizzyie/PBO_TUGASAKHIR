package peternakan_classes;

import java.util.Date;

public class Pembelian {
     int id;
     String namaBarang;
     int jumlahMasuk;
     Date tanggal;
     String supplier;

    public Pembelian(int id, String namaBarang, int jumlahMasuk, Date tanggal, String supplier) {
        this.id = id;
        this.namaBarang = namaBarang;
        this.jumlahMasuk = jumlahMasuk;
        this.tanggal = tanggal;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public int getJumlahMasuk() {
        return jumlahMasuk;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public void setJumlahMasuk(int jumlahMasuk) {
        this.jumlahMasuk = jumlahMasuk;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Pembelian{" +
                "id=" + id +
                ", namaBarang='" + namaBarang + '\'' +
                ", jumlahMasuk=" + jumlahMasuk +
                ", tanggal=" + tanggal +
                ", supplier='" + supplier + '\'' +
                '}';
    }
}

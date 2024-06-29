package Liza_project_model;

import java.util.Date;

public class Penjualan {
    private int id;
    private String namaBarang;
    private int jumlahKeluar;
    private Date tanggalKeluar;
    private String namaPembeli;
    private String alamat;
    private String namaSopir;
    private String nopol;
    private double beratNetto;
    private double rataRata;

    public Penjualan(int id, String namaBarang, int jumlahKeluar, Date tanggalKeluar, String namaPembeli, String alamat, String namaSopir, String nopol, double beratNetto, double rataRata) {
        this.id = id;
        this.namaBarang = namaBarang;
        this.jumlahKeluar = jumlahKeluar;
        this.tanggalKeluar = tanggalKeluar;
        this.namaPembeli = namaPembeli;
        this.alamat = alamat;
        this.namaSopir = namaSopir;
        this.nopol = nopol;
        this.beratNetto = beratNetto;
        this.rataRata = rataRata;
    }

    public int getId() {
        return id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public int getJumlahKeluar() {
        return jumlahKeluar;
    }

    public Date getTanggalKeluar() {
        return tanggalKeluar;
    }

    public String getNamaPembeli() {
        return namaPembeli;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNamaSopir() {
        return namaSopir;
    }

    public String getNopol() {
        return nopol;
    }

    public double getBeratNetto() {
        return beratNetto;
    }

    public double getRataRata() {
        return rataRata;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public void setJumlahKeluar(int jumlahKeluar) {
        this.jumlahKeluar = jumlahKeluar;
    }

    public void setTanggalKeluar(Date tanggalKeluar) {
        this.tanggalKeluar = tanggalKeluar;
    }

    public void setNamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNamaSopir(String namaSopir) {
        this.namaSopir = namaSopir;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    public void setBeratNetto(double beratNetto) {
        this.beratNetto = beratNetto;
    }

    public void setRataRata(double rataRata) {
        this.rataRata = rataRata;
    }

    @Override
    public String toString() {
        return "Penjualan{" +
                "id=" + id +
                ", namaBarang='" + namaBarang + '\'' +
                ", jumlahKeluar=" + jumlahKeluar +
                ", tanggalKeluar=" + tanggalKeluar +
                ", namaPembeli='" + namaPembeli + '\'' +
                ", alamat='" + alamat + '\'' +
                ", namaSopir='" + namaSopir + '\'' +
                ", nopol='" + nopol + '\'' +
                ", beratNetto=" + beratNetto +
                ", rataRata=" + rataRata +
                '}';
    }
}

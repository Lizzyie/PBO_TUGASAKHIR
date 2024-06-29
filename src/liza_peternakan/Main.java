package Liza_Peternakan;

import DAO.*;
import Liza_project_model.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BarangDAO barangDAO = new BarangDAO();
    private static final CatatanKeuanganDAO catatanKeuanganDAO = new CatatanKeuanganDAO();
    private static final PembelianDAO pembelianDAO = new PembelianDAO();
    private static final PenjualanDAO penjualanDAO = new PenjualanDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.print("Pilih operasi (1. Create, 2. Read, 3. Update, 4. Delete, 5. Exit): ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 5) break;

            System.out.print("Pilih tabel (1. Barang, 2. Catatan Keuangan, 3. Pembelian, 4. Penjualan): ");
            int tableChoice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> create(tableChoice);
                case 2 -> read(tableChoice);
                case 3 -> update(tableChoice);
                case 4 -> delete(tableChoice);
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void create(int tableChoice) {
        try {
            switch (tableChoice) {
                case 1 -> {
                    System.out.print("Nama Barang: ");
                    String namaBarang = scanner.nextLine();
                    System.out.print("Stok: ");
                    int stok = Integer.parseInt(scanner.nextLine());
                    System.out.print("Satuan: ");
                    String satuan = scanner.nextLine();
                    System.out.print("Jenis: ");
                    String jenis = scanner.nextLine();
                    Barang barang = new Barang(0, namaBarang, stok, satuan, jenis);
                    barangDAO.addBarang(barang);
                    System.out.println("Barang berhasil ditambahkan.");
                }
                case 2 -> {
                    System.out.print("Tanggal (yyyy-mm-dd): ");
                    Date tanggal = java.sql.Date.valueOf(scanner.nextLine());
                    System.out.print("Pengeluaran: ");
                    double pengeluaran = Double.parseDouble(scanner.nextLine());
                    System.out.print("Harga: ");
                    double harga = Double.parseDouble(scanner.nextLine());
                    System.out.print("Keterangan: ");
                    String keterangan = scanner.nextLine();
                    CatatanKeuangan catatanKeuangan = new CatatanKeuangan(0, tanggal, pengeluaran, harga, keterangan);
                    catatanKeuanganDAO.addCatatanKeuangan(catatanKeuangan);
                    System.out.println("Catatan keuangan berhasil ditambahkan.");
                }
                case 3 -> {
                    System.out.print("Nama Barang: ");
                    String namaBarang = scanner.nextLine();
                    System.out.print("Jumlah Masuk: ");
                    int jumlahMasuk = Integer.parseInt(scanner.nextLine());
                    System.out.print("Tanggal (yyyy-mm-dd): ");
                    Date tanggal = java.sql.Date.valueOf(scanner.nextLine());
                    System.out.print("Supplier: ");
                    String supplier = scanner.nextLine();
                    Pembelian pembelian = new Pembelian(0, namaBarang, jumlahMasuk, tanggal, supplier);
                    pembelianDAO.addPembelian(pembelian);
                    System.out.println("Pembelian berhasil ditambahkan.");
                }
                case 4 -> {
                    System.out.print("Nama Barang: ");
                    String namaBarang = scanner.nextLine();
                    System.out.print("Jumlah Keluar: ");
                    int jumlahKeluar = Integer.parseInt(scanner.nextLine());
                    System.out.print("Tanggal Keluar (yyyy-mm-dd): ");
                    Date tanggalKeluar = java.sql.Date.valueOf(scanner.nextLine());
                    System.out.print("Nama Pembeli: ");
                    String namaPembeli = scanner.nextLine();
                    System.out.print("Alamat: ");
                    String alamat = scanner.nextLine();
                    System.out.print("Nama Sopir: ");
                    String namaSopir = scanner.nextLine();
                    System.out.print("Nopol: ");
                    String nopol = scanner.nextLine();
                    System.out.print("Berat Netto: ");
                    double beratNetto = Double.parseDouble(scanner.nextLine());
                    System.out.print("Rata-rata: ");
                    double rataRata = Double.parseDouble(scanner.nextLine());
                    Penjualan penjualan = new Penjualan(0, namaBarang, jumlahKeluar, tanggalKeluar, namaPembeli, alamat, namaSopir, nopol, beratNetto, rataRata);
                    penjualanDAO.addPenjualan(penjualan);
                    System.out.println("Penjualan berhasil ditambahkan.");
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    private static void read(int tableChoice) {
        try {
            switch (tableChoice) {
                case 1 -> {
                    List<Barang> barangs = barangDAO.getAllBarang();
                    for (Barang barang : barangs) {
                        System.out.println(barang);
                    }
                }
                case 2 -> {
                    List<CatatanKeuangan> catatanKeuangans = catatanKeuanganDAO.getAllCatatanKeuangan();
                    for (CatatanKeuangan catatanKeuangan : catatanKeuangans) {
                        System.out.println(catatanKeuangan);
                    }
                }
                case 3 -> {
                    List<Pembelian> pembelians = pembelianDAO.getAllPembelian();
                    for (Pembelian pembelian : pembelians) {
                        System.out.println(pembelian);
                    }
                }
                case 4 -> {
                    List<Penjualan> penjualans = penjualanDAO.getAllPenjualan();
                    for (Penjualan penjualan : penjualans) {
                        System.out.println(penjualan);
                    }
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    private static void update(int tableChoice) {
        try {
            switch (tableChoice) {
                case 1 -> {
                    System.out.print("ID Barang yang akan diupdate: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nama Barang: ");
                    String namaBarang = scanner.nextLine();
                    System.out.print("Stok: ");
                    int stok = Integer.parseInt(scanner.nextLine());
                    System.out.print("Satuan: ");
                    String satuan = scanner.nextLine();
                    System.out.print("Jenis: ");
                    String jenis = scanner.nextLine();
                    Barang barang = new Barang(id, namaBarang, stok, satuan, jenis);
                    barangDAO.updateBarang(barang);
                    System.out.println("Barang berhasil diperbarui.");
                }
                case 2 -> {
                    System.out.print("ID Catatan Keuangan yang akan diupdate: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Tanggal (yyyy-mm-dd): ");
                    Date tanggal = java.sql.Date.valueOf(scanner.nextLine());
                    System.out.print("Pengeluaran: ");
                    double pengeluaran = Double.parseDouble(scanner.nextLine());
                    System.out.print("Harga: ");
                    double harga = Double.parseDouble(scanner.nextLine());
                    System.out.print("Keterangan: ");
                    String keterangan = scanner.nextLine();
                    CatatanKeuangan catatanKeuangan = new CatatanKeuangan(id, tanggal, pengeluaran, harga, keterangan);
                    catatanKeuanganDAO.updateCatatanKeuangan(catatanKeuangan);
                    System.out.println("Catatan keuangan berhasil diperbarui.");
                }
                case 3 -> {
                    System.out.print("ID Pembelian yang akan diupdate: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nama Barang: ");
                    String namaBarang = scanner.nextLine();
                    System.out.print("Jumlah Masuk: ");
                    int jumlahMasuk = Integer.parseInt(scanner.nextLine());
                    System.out.print("Tanggal (yyyy-mm-dd): ");
                    Date tanggal = java.sql.Date.valueOf(scanner.nextLine());
                    System.out.print("Supplier: ");
                    String supplier = scanner.nextLine();
                    Pembelian pembelian = new Pembelian(id, namaBarang, jumlahMasuk, tanggal, supplier);
                    pembelianDAO.updatePembelian(pembelian);
                    System.out.println("Pembelian berhasil diperbarui.");
                }
                case 4 -> {
                    System.out.print("ID Penjualan yang akan diupdate: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nama Barang: ");
                    String namaBarang = scanner.nextLine();
                    System.out.print("Jumlah Keluar: ");
                    int jumlahKeluar = Integer.parseInt(scanner.nextLine());
                    System.out.print("Tanggal Keluar (yyyy-mm-dd): ");
                    Date tanggalKeluar = java.sql.Date.valueOf(scanner.nextLine());
                    System.out.print("Nama Pembeli: ");
                    String namaPembeli = scanner.nextLine();
                    System.out.print("Alamat: ");
                    String alamat = scanner.nextLine();
                    System.out.print("Nama Sopir: ");
                    String namaSopir = scanner.nextLine();
                    System.out.print("Nopol: ");
                    String nopol = scanner.nextLine();
                    System.out.print("Berat Netto: ");
                    double beratNetto = Double.parseDouble(scanner.nextLine());
                    System.out.print("Rata-rata: ");
                    double rataRata = Double.parseDouble(scanner.nextLine());
                    Penjualan penjualan = new Penjualan(id, namaBarang, jumlahKeluar, tanggalKeluar, namaPembeli, alamat, namaSopir, nopol, beratNetto, rataRata);
                    penjualanDAO.updatePenjualan(penjualan);
                    System.out.println("Penjualan berhasil diperbarui.");
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    private static void delete(int tableChoice) {
        try {
            System.out.print("ID yang akan dihapus: ");
            int id = Integer.parseInt(scanner.nextLine());
            switch (tableChoice) {
                case 1 -> {
                    barangDAO.deleteBarang(id);
                    System.out.println("Barang berhasil dihapus.");
                }
                case 2 -> {
                    catatanKeuanganDAO.deleteCatatanKeuangan(id);
                    System.out.println("Catatan keuangan berhasil dihapus.");
                }
                case 3 -> {
                    pembelianDAO.deletePembelian(id);
                    System.out.println("Pembelian berhasil dihapus.");
                }
                case 4 -> {
                    penjualanDAO.deletePenjualan(id);
                    System.out.println("Penjualan berhasil dihapus.");
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
                    

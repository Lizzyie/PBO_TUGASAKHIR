/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import javax.swing.JOptionPane;

public class Database {
    private String databaseName = "liza_2210010347";
    private String username = "root";
    private String pass = "";
    private String lokasi = "jdbc:mysql://localhost:3306/" + databaseName;
    public static Connection KoneksiDB;

    public Database(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            KoneksiDB = DriverManager.getConnection(lokasi, username, pass);
//            JOptionPane.showMessageDialog(null, "Koneksi ke database berhasil!", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Database Terkoneksi!");
            
        } catch (Exception e) {
            System.err.println(e.toString());
//            JOptionPane.showMessageDialog(null, "Koneksi ke database gagal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Table Penjualan
    public void simpanPenjualan(int paramId, String NamaBarang, String JumlahKeluar, String paramDate, String NamaPembeli, String paramAlamat, String NamaSopir, String paramNopol, int BeratNetto, double rerata) {
        try {
            String SQL = "INSERT INTO penjualan (ID, Nama_barang, Jumlah_keluar, Tanggal_keluar, Nama_pembeli, Alamat, Nama_sopir, Nopol, Berat_netto, Rata_rata) VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.setString(2, NamaBarang);
            perintah.setString(3, JumlahKeluar);
            perintah.setString(4, paramDate);
            perintah.setString(5, NamaPembeli);
            perintah.setString(6, paramAlamat);
            perintah.setString(7, NamaSopir);
            perintah.setString(8, paramNopol);
            perintah.setInt(9, BeratNetto);
            perintah.setDouble(10, rerata);
            perintah.executeUpdate();
            System.out.println("Data Berhasil disimpan!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updatePenjualan(int paramId, String NamaBarang, String JumlahKeluar, String paramDate, String NamaPembeli, String paramAlamat, String NamaSopir, String paramNopol, int BeratNetto, double rerata) {
        try {
            String SQL = "UPDATE penjualan SET Nama_barang =?, Jumlah_keluar =?, Tanggal_keluar=?, Nama_pembeli=?, Alamat=?, Nama_sopir=?, Nopol=?, Berat_netto=?, Rata_rata=? WHERE ID=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setString(1, NamaBarang);
            perintah.setString(2, JumlahKeluar);
            perintah.setString(3, paramDate);
            perintah.setString(4, NamaPembeli);
            perintah.setString(5, paramAlamat);
            perintah.setString(6, NamaSopir);
            perintah.setString(7, paramNopol);
            perintah.setInt(8, BeratNetto);
            perintah.setDouble(9, rerata);
            perintah.setInt(10, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil diupdate!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusPenjualan(int paramId) {
        try {
            String SQL = "DELETE FROM penjualan WHERE ID=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil dihapus!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    
    // Table Barang
    public void simpanBarang(int paramId, String NamaBarang, int paramStok, String paramSatuan, String paramJenis) {
        try {
            String SQL = "INSERT INTO barang (ID, Nama_barang, Stok, Satuan, Jenis) VALUES(?,?,?,?,?)";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.setString(2, NamaBarang);
            perintah.setInt(3, paramStok);
            perintah.setString(4, paramSatuan);
            perintah.setString(5, paramJenis);
            perintah.executeUpdate();
            System.out.println("Data Berhasil disimpan!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updateBarang(int paramId, String NamaBarang, int paramStok, String paramSatuan, String paramJenis) {
        try {
            String SQL = "UPDATE barang SET Nama_barang =?, Stok =?, Satuan=?, Jenis=? WHERE ID=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setString(1, NamaBarang);
            perintah.setInt(2, paramStok);
            perintah.setString(3, paramSatuan);
            perintah.setString(4, paramJenis);
            perintah.setInt(5, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil diupdate!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusBarang(int paramId) {
        try {
            String SQL = "DELETE FROM barang WHERE ID=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil dihapus!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    // Table Pembelian
    public void simpanPembelian(int paramId, String NamaBarang, String jmlMasuk, String date, String paramSupplier) {
        try {
            String SQL = "INSERT INTO pembelian (ID, Nama_barang, Jumlah_masuk, Tanggal, Supplier) VALUES(?,?,?,?,?)";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.setString(2, NamaBarang);
            perintah.setString(3, jmlMasuk);
            perintah.setString(4, date);
            perintah.setString(5, paramSupplier);
            perintah.executeUpdate();
            System.out.println("Data Berhasil disimpan!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updatePembelian(int paramId, String NamaBarang, String jmlMasuk, String date, String paramSupplier) {
        try {
            String SQL = "UPDATE pembelian SET Nama_barang =?, Jumlah_masuk =?, Tanggal=?, Supplier=? WHERE ID=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setString(1, NamaBarang);
            perintah.setString(2, jmlMasuk);
            perintah.setString(3, date);
            perintah.setString(4, paramSupplier);
            perintah.setInt(5, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil diupdate!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusPembelian(int paramId) {
        try {
            String SQL = "DELETE FROM pembelian WHERE ID=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil dihapus!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    // Tabel Catatan Keuangan
    public void simpanCttUang(int paramId, String date, String pengeluaran, String harga, String ket) {
        try {
            String SQL = "INSERT INTO catatan_keuangan (ID, Tanggal, pengeluaran, Harga, Keterangan) VALUES(?,?,?,?,?)";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.setString(2, date);
            perintah.setString(3, pengeluaran);
            perintah.setString(4, harga);
            perintah.setString(5, ket);
            perintah.executeUpdate();
            System.out.println("Data Berhasil disimpan!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updateCttUang(int paramId, String date, String pengeluaran, String harga, String ket) {
        try {
            String SQL = "UPDATE catatan_keuangan SET Tanggal =?, pengeluaran =?, Harga=?, Keterangan=? WHERE ID=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setString(1, date);
            perintah.setString(2, pengeluaran);
            perintah.setString(3, harga);
            perintah.setString(4, ket);
            perintah.setInt(5, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil diupdate!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusCttUang(int paramId) {
        try {
            String SQL = "DELETE FROM catatan_keuangan WHERE ID=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil dihapus!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

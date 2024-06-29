package DAO;

import Koneksi.Database;
import Liza_project_model.Penjualan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PenjualanDAO {
    public void addPenjualan(Penjualan penjualan) throws SQLException {
        String query = "INSERT INTO penjualan (nama_barang, jumlah_keluar, tanggal_keluar, nama_pembeli, alamat, nama_sopir, nopol, berat_netto, rata_rata) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, penjualan.getNamaBarang());
            stmt.setInt(2, penjualan.getJumlahKeluar());
            stmt.setDate(3, new java.sql.Date(penjualan.getTanggalKeluar().getTime()));
            stmt.setString(4, penjualan.getNamaPembeli());
            stmt.setString(5, penjualan.getAlamat());
            stmt.setString(6, penjualan.getNamaSopir());
            stmt.setString(7, penjualan.getNopol());
            stmt.setDouble(8, penjualan.getBeratNetto());
            stmt.setDouble(9, penjualan.getRataRata());
            stmt.executeUpdate();
        }
    }

    public List<Penjualan> getAllPenjualan() throws SQLException {
        List<Penjualan> penjualanList = new ArrayList<>();
        String query = "SELECT * FROM penjualan";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Penjualan penjualan = new Penjualan(
                        rs.getInt("id"),
                        rs.getString("nama_barang"),
                        rs.getInt("jumlah_keluar"),
                        rs.getDate("tanggal_keluar"),
                        rs.getString("nama_pembeli"),
                        rs.getString("alamat"),
                        rs.getString("nama_sopir"),
                        rs.getString("nopol"),
                        rs.getDouble("berat_netto"),
                        rs.getDouble("rata_rata")
                );
                penjualanList.add(penjualan);
            }
        }
        return penjualanList;
    }

    public void updatePenjualan(Penjualan penjualan) throws SQLException {
        String query = "UPDATE penjualan SET nama_barang=?, jumlah_keluar=?, tanggal_keluar=?, nama_pembeli=?, alamat=?, nama_sopir=?, nopol=?, berat_netto=?, rata_rata=? WHERE id=?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, penjualan.getNamaBarang());
            stmt.setInt(2, penjualan.getJumlahKeluar());
            stmt.setDate(3, new java.sql.Date(penjualan.getTanggalKeluar().getTime()));
            stmt.setString(4, penjualan.getNamaPembeli());
            stmt.setString(5, penjualan.getAlamat());
            stmt.setString(6, penjualan.getNamaSopir());
            stmt.setString(7, penjualan.getNopol());
            stmt.setDouble(8, penjualan.getBeratNetto());
            stmt.setDouble(9, penjualan.getRataRata());
            stmt.setInt(10, penjualan.getId());
            stmt.executeUpdate();
        }
    }

    public void deletePenjualan(int id) throws SQLException {
        String query = "DELETE FROM penjualan WHERE id=?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

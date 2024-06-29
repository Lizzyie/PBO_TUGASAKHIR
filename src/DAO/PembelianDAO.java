package DAO;

import Koneksi.Database;
import Liza_project_model.Pembelian;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PembelianDAO {
    public void addPembelian(Pembelian pembelian) throws SQLException {
        String query = "INSERT INTO pembelian (nama_barang, jumlah_masuk, tanggal, supplier) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, pembelian.getNamaBarang());
            stmt.setInt(2, pembelian.getJumlahMasuk());
            stmt.setDate(3, new java.sql.Date(pembelian.getTanggal().getTime()));
            stmt.setString(4, pembelian.getSupplier());
            stmt.executeUpdate();
        }
    }

    public List<Pembelian> getAllPembelian() throws SQLException {
        List<Pembelian> pembelianList = new ArrayList<>();
        String query = "SELECT * FROM pembelian";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Pembelian pembelian = new Pembelian(
                        rs.getInt("id"),
                        rs.getString("nama_barang"),
                        rs.getInt("jumlah_masuk"),
                        rs.getDate("tanggal"),
                        rs.getString("supplier")
                );
                pembelianList.add(pembelian);
            }
        }
        return pembelianList;
    }

    public void updatePembelian(Pembelian pembelian) throws SQLException {
        String query = "UPDATE pembelian SET nama_barang=?, jumlah_masuk=?, tanggal=?, supplier=? WHERE id=?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, pembelian.getNamaBarang());
            stmt.setInt(2, pembelian.getJumlahMasuk());
            stmt.setDate(3, new java.sql.Date(pembelian.getTanggal().getTime()));
            stmt.setString(4, pembelian.getSupplier());
            stmt.setInt(5, pembelian.getId());
            stmt.executeUpdate();
        }
    }

    public void deletePembelian(int id) throws SQLException {
        String query = "DELETE FROM pembelian WHERE id=?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

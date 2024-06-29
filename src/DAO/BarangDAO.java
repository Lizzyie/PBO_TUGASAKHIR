package DAO;

import Koneksi.Database;
import Liza_project_model.Barang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BarangDAO {
    public void addBarang(Barang barang) throws SQLException {
        String query = "INSERT INTO barang (nama_barang, stok, satuan, jenis) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, barang.getNamaBarang());
            stmt.setInt(2, barang.getStok());
            stmt.setString(3, barang.getSatuan());
            stmt.setString(4, barang.getJenis());
            stmt.executeUpdate();
        }
    }

    public List<Barang> getAllBarang() throws SQLException {
        List<Barang> barangList = new ArrayList<>();
        String query = "SELECT * FROM barang";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Barang barang = new Barang(
                        rs.getInt("id"),
                        rs.getString("nama_barang"),
                        rs.getInt("stok"),
                        rs.getString("satuan"),
                        rs.getString("jenis")
                );
                barangList.add(barang);
            }
        }
        return barangList;
    }

    public void updateBarang(Barang barang) throws SQLException {
        String query = "UPDATE barang SET nama_barang=?, stok=?, satuan=?, jenis=? WHERE id=?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, barang.getNamaBarang());
            stmt.setInt(2, barang.getStok());
            stmt.setString(3, barang.getSatuan());
            stmt.setString(4, barang.getJenis());
            stmt.setInt(5, barang.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteBarang(int id) throws SQLException {
        String query = "DELETE FROM barang WHERE id=?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

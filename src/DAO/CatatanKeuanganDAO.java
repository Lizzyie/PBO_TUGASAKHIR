package DAO;

import Koneksi.Database;
import Liza_project_model.CatatanKeuangan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatatanKeuanganDAO {
    public void addCatatanKeuangan(CatatanKeuangan catatan) throws SQLException {
        String query = "INSERT INTO catatan_keuangan (tanggal, pengeluaran, harga, keterangan) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDate(1, new java.sql.Date(catatan.getTanggal().getTime()));
            stmt.setDouble(2, catatan.getPengeluaran());
            stmt.setDouble(3, catatan.getHarga());
            stmt.setString(4, catatan.getKeterangan());
            stmt.executeUpdate();
        }
    }

    public List<CatatanKeuangan> getAllCatatanKeuangan() throws SQLException {
        List<CatatanKeuangan> catatanList = new ArrayList<>();
        String query = "SELECT * FROM catatan_keuangan";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CatatanKeuangan catatan = new CatatanKeuangan(
                        rs.getInt("id"),
                        rs.getDate("tanggal"),
                        rs.getDouble("pengeluaran"),
                        rs.getDouble("harga"),
                        rs.getString("keterangan")
                );
                catatanList.add(catatan);
            }
        }
        return catatanList;
    }

    public void updateCatatanKeuangan(CatatanKeuangan catatan) throws SQLException {
        String query = "UPDATE catatan_keuangan SET tanggal=?, pengeluaran=?, harga=?, keterangan=? WHERE id=?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDate(1, new java.sql.Date(catatan.getTanggal().getTime()));
            stmt.setDouble(2, catatan.getPengeluaran());
            stmt.setDouble(3, catatan.getHarga());
            stmt.setString(4, catatan.getKeterangan());
            stmt.setInt(5, catatan.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteCatatanKeuangan(int id) throws SQLException {
        String query = "DELETE FROM catatan_keuangan WHERE id=?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.FeePayment;

public class FeePaymentDAO {

    // 🔷 Database connection details
    private String url = "jdbc:mysql://localhost:3306/college";
    private String user = "root";
    private String pass = "harshitha";

    // 🔷 Load driver and get connection
    private Connection getCon() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }

    // 🔷 INSERT (Add Payment)
    public void insert(FeePayment f) throws Exception {

        Connection con = getCon();

        String sql = "INSERT INTO FeePayments (StudentID, StudentName, PaymentDate, Amount, Status) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, f.getStudentId());
        ps.setString(2, f.getStudentName());
        ps.setDate(3, f.getPaymentDate());
        ps.setDouble(4, f.getAmount());
        ps.setString(5, f.getStatus());

        ps.executeUpdate();
        con.close();
    }

    // 🔷 SELECT ALL (Display)
    public List<FeePayment> getAll() throws Exception {

        List<FeePayment> list = new ArrayList<>();

        Connection con = getCon();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM FeePayments");

        while (rs.next()) {
            FeePayment f = new FeePayment();

            f.setPaymentId(rs.getInt("PaymentID"));
            f.setStudentId(rs.getInt("StudentID"));
            f.setStudentName(rs.getString("StudentName"));
            f.setPaymentDate(rs.getDate("PaymentDate"));
            f.setAmount(rs.getDouble("Amount"));
            f.setStatus(rs.getString("Status"));

            list.add(f);
        }

        con.close();
        return list;
    }

    // 🔷 DELETE
    public void delete(int id) throws Exception {

        Connection con = getCon();

        String sql = "DELETE FROM FeePayments WHERE PaymentID=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.executeUpdate();

        con.close();
    }

    // 🔷 UPDATE
    public void update(FeePayment f) throws Exception {

        Connection con = getCon();

        String sql = "UPDATE FeePayments SET StudentID=?, StudentName=?, PaymentDate=?, Amount=?, Status=? WHERE PaymentID=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, f.getStudentId());
        ps.setString(2, f.getStudentName());
        ps.setDate(3, f.getPaymentDate());
        ps.setDouble(4, f.getAmount());
        ps.setString(5, f.getStatus());
        ps.setInt(6, f.getPaymentId());

        ps.executeUpdate();

        con.close();
    }
}
package vn.hka.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vn.hka.Controllers.DBConnect;
import vn.hka.dao.ILogindao;
import vn.hka.model.loginmodel;

public class LogindaoImpl extends DBConnect implements ILogindao {

    @Override
    public loginmodel findByUsername(String username) {
        String sql = "SELECT * FROM Btlogin WHERE username = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        loginmodel user = null;

        try {
            conn = super.getConnection(); // 
            if (conn == null) {
                System.out.println("Kết nối tới cơ sở dữ liệu thất bại.");
                return null;
            }

            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                user = new loginmodel();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }
}

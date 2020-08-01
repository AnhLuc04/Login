package View;

import Model.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDao implements ManageAdmin {
    private String jdbcURL = "jdbc:mysql://localhost:3306/manage?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "04032001";

    private static final String INSERT_USERS_SQL = "INSERT INTO admin" + "  (url,name,password,Description) VALUES " +
            " (?, ?, ?,?);";

    private static final String SELECT_USER_BY_ID = "select id,url,name,password,Description from admin where id =?";
    private static final String SELECT_ALL_USERS = "select * from admin";
    private static final String DELETE_USERS_SQL = "delete from admin where id = ?;";
    private static final String UPDATE_USERS_SQL = "update admin set url=?, set name = ?,password= ?,Description=? where id = ?;";
    private static final String Admin= "SELECT name, password,id FROM admin WHERE name = ?";
    public void AdminDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("oke");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public Admin Login(String name) {

        try {
            PreparedStatement ps = getConnection().prepareStatement(Admin);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String Name = rs.getString(1);
                String password = rs.getString(2);
                int id = rs.getInt(3);
                return new Admin(Name, password, id);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi thực thi lệnh SQL SELECT");
        }
        return null;
    }
    @Override
    public void insertAdmin(Admin admin) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, admin.getUrl());
            preparedStatement.setString(2, admin.getName());
            preparedStatement.setString(3, admin.getPassword());
            preparedStatement.setString(4, admin.getDescription());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            new SQLException(e);
        }
    }

    @Override
    public Admin selectAdmin(int id) {
        Admin admin = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String url = rs.getString("url");
                String name = rs.getString("name");
                String password  = rs.getString("password ");
                String Description = rs.getString("Description");
                admin = new Admin(id,url, name,password,Description);
            }
        } catch (SQLException e) {
            new SQLException(e);
        }
        return admin;
    }

    @Override
    public List<Admin> selectAllAdmin() {
        List<Admin> admins= new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String url = rs.getString("url");
                String name = rs.getString("name");
                String password  = rs.getString("password ");
                String Description = rs.getString("Description");
                admins.add(new Admin(id,url, name,password,Description));
            }
        } catch (SQLException e) {
            new SQLException(e);
        }
        return admins;
    }

    @Override
    public boolean deleteAdmin(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateAdmin(Admin admin) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, admin.getUrl());
            statement.setString(2, admin.getName());
            statement.setString(3, admin.getPassword());
            statement.setString(4, admin.getDescription());
            statement.setInt(5, admin.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}

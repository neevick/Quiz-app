package dao;

import model.User;
import view.LoginView;

import java.sql.*;

public class UserDAO {
    public boolean insertUser(User user){
        boolean isUserInserted = false;
        Connection conn = null;
        try {
            conn = DatabaseConnection.connect();
            if(conn != null){
                String query = "INSERT INTO user (username, password) VALUES (?, ?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                int row = ps.executeUpdate();
                if(row > 0){
                    isUserInserted = true;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return isUserInserted;
    }

    public boolean checkUser(User user){
        boolean isSignedUpUser = false;
        Connection conn = null;
        try {
            conn = DatabaseConnection.connect();
            if (conn != null){
                String query = "SELECT username, password, isGameMaster FROM user WHERE username = ? AND password = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, user.getUsername());
                ps.setString(2,user.getPassword());
                try {
                    ResultSet resultSet = ps.executeQuery();
                    if (resultSet.next()){
                        isSignedUpUser = true;
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return isSignedUpUser;
    }
}

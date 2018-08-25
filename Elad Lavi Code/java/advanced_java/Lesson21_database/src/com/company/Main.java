package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try(Connection conn = getConn()) {
            try(PreparedStatement statement = conn.prepareStatement("SELECT user_name,password FROM users")){
                try(ResultSet resultSet = statement.executeQuery()){
                    while (resultSet.next()){
                        String userName = resultSet.getString(1);
                        String password = resultSet.getString(2);
                        System.out.println(userName + " " + password);
                    }
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConn() throws SQLException {
        String connection = "jdbc:mysql://localhost:3306/chatdb?useSSL=false";
        String user = "root";
        String password = "q1w2e3!";
        return DriverManager.getConnection(connection, user, password);
    }
}

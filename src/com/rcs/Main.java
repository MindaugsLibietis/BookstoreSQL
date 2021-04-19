package com.rcs;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Connection conn = null;
        List<Author> authors = new ArrayList<>();
        try {
            String url = "jdbc:mysql://localhost:3306/bookstore";
            String user = "root";
            String password = "xxxx";

            conn = DriverManager.getConnection(url, user, password);
            String sql = "insert into author(name, surname, gender, country, dateOfBirth)" + "values(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "Aivars");
            preparedStatement.setString(2, "Vitins");
            preparedStatement.setString(3, "Male");
            preparedStatement.setString(4, "Latvija");
            preparedStatement.setDate(5,new Date(1980,3,11));
            preparedStatement.executeUpdate();
            preparedStatement.close();

            sql = "update author set country = ? where id = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "Lietuva");
            preparedStatement.setInt(2, 3);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            Statement statement = conn.createStatement();
            sql = "select id, name, surname, dateOfBirth, gender, country from author";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                Date dateOfBirth = rs.getDate("dateOfBirth");
                Gender gender = Gender.valueOf(rs.getString("gender").toUpperCase());
                String country = rs.getString("country");
                authors.add(new Author(id, name, surname, gender, country, dateOfBirth));
            }
            statement.close();
            for (Author author : authors) {
                System.out.println(author);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

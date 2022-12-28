package me.boris.mysql;

import java.sql.*;

public class Conexion {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    private final String URL = "jdbc:mysql://localhost:3309/facturita";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";


    public Conexion() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver cargado");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexion establecida");
            //connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean updateCreateDelete(String sqla){

        try {
            statement= connection.createStatement();
            statement.execute(sqla);
            statement.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet select(String sql){

        try {
            statement= connection.createStatement();
            resultSet= statement.executeQuery(sql);
          // resultSet.close();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}

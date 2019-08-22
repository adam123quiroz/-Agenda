package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Database {

    private static final String URL = "jdbc:mysql://localhost:3307/agenda";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admi";
    private Connection connection = null; // se maneja la conexion

    Database() {

        try {

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException sqlException) {

            sqlException.printStackTrace();
            System.exit( 1 );
        }
    }

    Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    static String getUrl() {
        return URL;
    }

    static String getUsername() {
        return USERNAME;
    }

    static String getPassword() {
        return PASSWORD;
    }

}
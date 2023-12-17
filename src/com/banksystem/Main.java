package com.banksystem;

import com.banksystem.db.DatabaseConnection;
import com.banksystem.navigation.Navigation;

import java.sql.*;

public class Main {
    // private static final String driverName = "org.mariadb.jdbc.Driver";
    // private static final String databaseUrl = "jdbc:mariadb://localhost:3307";
    // private static Connection c = null;
    // private static Statement s = null;
    //
    //
    // public static void main(String[] args) throws SQLException,
    // ClassNotFoundException {
    // String dbName = "vince";
    // ResultSet tables;
    // ResultSet databases;
    // try {
    // Class.forName(driverName);
    // c = DriverManager.getConnection(databaseUrl,"root","vince");
    // System.out.println("Established Connection");
    // c.setAutoCommit(true);
    // s = c.createStatement();
    //
    // DatabaseMetaData metaData = c.getMetaData();
    // databases = metaData.getCatalogs();
    // tables = metaData.getTables(null, null, "vince", null);
    // } catch (ClassNotFoundException e) {
    // System.out.println("Class not Found");
    // System.out.println(e.getMessage());
    // return;
    // } catch (SQLException e) {
    // System.out.println("Error");
    // return;
    // }
    //
    // // Create Database
    // try {
    // String query = "CREATE DATABASE Vince";
    //// if (databases.next()) {
    //// String databaseName = databases.getString("vince");
    //// if (dbName.equalsIgnoreCase(dbName)){
    //// System.out.println("Database " + databaseName + " exists");
    //// }
    //// } else {
    // s.executeUpdate(query);
    //// }
    // System.out.println("Database Created");
    // } catch (SQLException e) {
    // e.printStackTrace();
    // System.out.println("Could not create database");
    // }
    //
    // try {
    // String query1 = "create table accounts( id int not null auto_increment, name
    // varchar(255) not null, age int not null, password varchar(255) not null,
    // balance int not null, primary key(id) )";
    // String query2 = "create table transactions( id int not null auto_increment,
    // account_id int not null, transaction_type varchar(255) not null, amount int
    // not null, primary key(id), foreign key(account_id) references accounts(id)
    // )";
    //
    // // Checking
    // if (tables.next()){
    // System.out.println("Table Exists");
    // } else {
    // s.execute(query1);
    // s.execute(query2);
    // }
    // } catch (SQLException ignored){
    // }
    //
    // // TODO: SETUP DATABASE TO REPOSITORY
    //
    // }
    public static void main(String[] args) {
        Navigation.login();
    }
}

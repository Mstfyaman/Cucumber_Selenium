package com.krafttech.jdbc_Test;

import java.sql.*;

public class Test_JDBC_Connection {
    public static void main(String[] args) {



        String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;encrypt=true;trustServerCertificate=true;";
        String userName="u0583688_vlk";
        String password="VolkanAntalya159*";
        String query="Select TOP(10) * from u0583688_vlk.dbo.otomobil_fiyatlari of2";

        try {
            Connection connection = DriverManager.getConnection(url,userName,password); // proje ile DataBase yi bağlar
            System.out.println("CONNECTİON OK");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            System.out.println(resultSet.getString(1));   // 1. satırdaki ürünün aşağıya doğru sütünlarını yazdırır. kaç tane girersek
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
            System.out.println(resultSet.getString(5));
            System.out.println(resultSet.getString(6));

            System.out.println("--------------------------");

            resultSet.next(); // burda 2. satırdaki ürüne geçtik
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
            System.out.println(resultSet.getString(5));
            System.out.println(resultSet.getString(6));

        } catch (SQLException e) {
            System.out.println("CONNECTİON ERROR" + e.getMessage());
        }


    }
}

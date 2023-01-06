package com.krafttech.jdbc_Test;

import java.sql.*;
import java.util.List;

public class Test_JDBC_2 {
    public static void main(String[] args) {

        String url = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;encrypt=true;trustServerCertificate=true;";
        String userName="u0583688_vlk";
        String password="VolkanAntalya159*";
        String query="Select TOP(10) * from u0583688_vlk.dbo.otomobil_fiyatlari of2";
       // String query="select  DISTINCT  marka  from u0583688_vlk.dbo.otomobil_fiyatlari of2";


        try {
            Connection connection = DriverManager.getConnection(url,userName,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
           resultSet.next();
            System.out.println(resultSet.getRow() + " | " + resultSet.getString(2));
            resultSet.next();

            System.out.println(resultSet.getRow() + " | " + resultSet.getString(3));
                // bulunduğumuz sıranın numarası(getRow)
            System.out.println(resultSet.getString("yakit")); // tabloya ait colum ismiyle çağırma
            System.out.println(resultSet.getString("websitesi")); // tabloya ait colum ismiyle çağırma

            System.out.println("--------------------------");

            int fiyat= resultSet.getInt("fiyat"); // fiyatı string olarak değilde int olarak istersek böyle yapıyoruz
            System.out.println("fiyat = " + fiyat);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

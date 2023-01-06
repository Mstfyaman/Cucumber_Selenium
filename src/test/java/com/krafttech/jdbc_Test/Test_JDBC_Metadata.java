package com.krafttech.jdbc_Test;

import java.sql.*;

public class Test_JDBC_Metadata {
    public static void main(String[] args) {

        String url = "jdbc:sqlserver://94.73.150.3:1433;" +
                "DatabaseName=u0583688_vlk;" +   // database ismi
                "encrypt=true;" + // database şifrelensin mi?
                "trustServerCertificate=true;"; // sertifikaya güveneyim mi
        String userName="u0583688_vlk";
        String password="VolkanAntalya159*";
        String query="Select TOP(10) * from u0583688_vlk.dbo.otomobil_fiyatlari of2";
     //   String query="select  DISTINCT  marka  from u0583688_vlk.dbo.otomobil_fiyatlari of2";


        try {
            Connection connection = DriverManager.getConnection(url,userName,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData metaData = resultSet.getMetaData();  // interface oluşturduk

            System.out.println("kolon sayısı = " + metaData.getColumnCount());
            System.out.println(" kolon isimleri : "+metaData.getColumnName(8)+ " | "+ metaData.getColumnName(9) );


            int kolonsayısı = metaData.getColumnCount();

            for (int i = 1; i<= kolonsayısı; i++){
                System.out.println("Kolon " + i + " => " + metaData.getColumnName(i));
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
}

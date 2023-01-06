package com.krafttech.jdbc_Test;

import java.sql.*;

public class Test_JDBC_Metadata_2 {
    public static void main(String[] args) {

        String url= "jdbc:sqlserver://94.73.170.25:1433;" +  // burası  ip ile portu içerir
                "DatabaseName=u0583688_Kraft2;" + // databasenin ismi
                "encrypt=true;" + // bunu şifreleyerek göndermeyi kabul ediyorum
                "trustServerCertificate=true;"; // database serverinin sertifikalı olduğuna güveniyorum

        String userName="u0583688_Kraft2";
        String password="ANKARA123456789*0987654fg";
        String query="SELECT TOP(10) * FROM u0583688_Kraft2.product.brand";


        try (Connection connection= DriverManager.getConnection(url,userName,password);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
             ResultSet  resultSet = statement.executeQuery(query);
        )
        {
            ResultSetMetaData metaData = resultSet.getMetaData();

            metaData.getColumnCount();
            System.out.println("metaData.getColumnCount() = " + metaData.getColumnCount());


            // ColumnCount u kullanarak ilk satırın değerlerini ekrana yazdıralım

          //  resultSet.next();
//           for ( int i=1; i <=metaData.getColumnCount(); i++){
//               System.out.println(i+ ".row = " + resultSet.getString(i));
//           }



           //columncountu kullanarak bütün rowları alt alta yazdıralım

//            int kolumsayısı = metaData.getColumnCount();
//
//           while (resultSet.next()){
//               for ( int i=1; i <=kolumsayısı; i++){
//                   System.out.print(resultSet.getString(i)+"\t");
//               }
//               System.out.println("");
//           }


           //Tablomuzun kolon isimleriyle beraber yazdıralım

            int kolumsayısı = metaData.getColumnCount();

            for ( int i=1; i <=kolumsayısı; i++){
                System.out.print(metaData.getColumnName(i)+ "\t");
            }
            System.out.println("");

            while (resultSet.next()){
                for ( int i=1; i <=kolumsayısı; i++){
                    System.out.print(resultSet.getString(i)+ "\t"+"\t"+"\t");
                }
                System.out.println("");
            }










           } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }












    }
}

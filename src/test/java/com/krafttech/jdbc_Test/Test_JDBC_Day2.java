package com.krafttech.jdbc_Test;

import com.sun.source.tree.WhileLoopTree;

import java.sql.*;

public class Test_JDBC_Day2 {
    public static void main(String[] args) {

        String url= "jdbc:sqlserver://94.73.170.25:1433;" +  // burası  ip ile portu içerir
                "DatabaseName=u0583688_Kraft2;" + // databasenin ismi
                "encrypt=true;" + // bunu şifreleyerek göndermeyi kabul ediyorum
                "trustServerCertificate=true;"; // database serverinin sertifikalı olduğuna güveniyorum

        String userName="u0583688_Kraft2";
        String password="ANKARA123456789*0987654fg";
        String query="SELECT TOP(10) * FROM u0583688_Kraft2.product.brand";


        try {

            Connection connection = DriverManager.getConnection(url,userName,password);
            Statement statement =connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    // üstteki satırda statementin içerisine yazdıklarımız resultSet ile birlikte bazı methodları kullanmamızı sağlar
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.close();
            statement.close();
            connection.close();







//            System.out.println("Connection occured");
//            resultSet.next(); // ilk satırın içerisine girdik
//            System.out.println("resultSet.getString(2) = " + resultSet.getString(2));

//            resultSet.next();
//            System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
//            resultSet.previous();
//            System.out.println("resultSet.getString(2) = " + resultSet.getString(2));

//            resultSet.last(); // sonuncu row u getirir
//            System.out.println("resultSet.getString(2) = " + resultSet.getString(2));

//            resultSet.beforeFirst(); // 1. sıranın dışına çıkmış oluyoruz. bir yerlerde kullanıyordur. şuan bizim işimize yaramadı
//            System.out.println("resultSet.getString(2) = " + resultSet.getString(2));

//            resultSet.absolute(5); // istediğimiz row a gidebiliriz
//            System.out.println("absolute(5) = " + resultSet.getString(2));

          //  resultSet.afterLast(); // // son sıranın dışına çıkmış oluyoruz. bir yerlerde kullanıyordur. şuan bizim işimize yaramadı



         ////// ///// ///////////////////////////////////

            resultSet.beforeFirst();
        // TASK :   Tüm rowların ilk iki kolonunu bir döngüyle alta yazdıralım



//            for (int i = 1; i<= 10; i++){
//                resultSet.next();
//                System.out.println(resultSet.getString(1)+" => "+ resultSet.getString(2));
//            }


//            while ( resultSet.next()){
//                System.out.println(resultSet.getString(1)+" => "+ resultSet.getString(2));
//            }
//            System.out.println("while loop bitti");

        /////////////////////////////////////////////////

        resultSet.next();
            System.out.println("mevcut row sırası = " +resultSet.getRow());

            // 2 kodla toplam row sayısı
            resultSet.last();
            System.out.println(resultSet.getRow());


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

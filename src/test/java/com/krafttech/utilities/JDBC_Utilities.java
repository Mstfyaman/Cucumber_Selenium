package com.krafttech.utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC_Utilities {

    static String url = "jdbc:sqlserver://94.73.150.3:1433;" +
            "DatabaseName=u0583688_vlk;" +
            "encrypt=true;" +
            "trustServerCertificate=true;";
    static String userName = "u0583688_vlk";
    static String password ="VolkanAntalya159*";
    static String query = "SELECT * from u0583688_vlk.dbo.regions";

    static Statement statement ;
    static Connection connection ;
    static ResultSet resultSet ;
    static  ResultSetMetaData resultSetMetaData;

    // Bu classı 13.01.2023 cuma günü extra oalrak oluşturduk.JDBC dersinde gördüklerimizi kısayol yaptık.

    public static void main(String[] args) throws SQLException {

        connectJdbc();
        runQuery();
        getRowCount();
        getResultSetMetaData();
        getColumnCount();
        gelAllColumnNameAsList();


        for (String str : getRowDataAsList(1)){
            System.out.println(str+"\t");
        }





        //  closeJDBC();

    }





    static void connectJdbc(){

        try {
            connection  = DriverManager.getConnection(url,userName,password);
            System.out.println("Connection OK");

        } catch (SQLException e) {
            System.out.println("Connection FAİLED");
            System.out.println(e.getMessage());

        }
    }


    static ResultSet runQuery(){
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(query);
            System.out.println("resultSet get result from DB");

        } catch (SQLException e) {
            System.out.println("resultSet FAİLED");
            System.out.println(e.getMessage());
        }
        return  resultSet;
    }


    static void closeJDBC(){

        try {
            if (resultSet!=null){
                resultSet.close();
                System.out.println("resultSet closed");
            }
            if (statement!=null){
                statement.close();
                System.out.println("statement closed");
            }
            if (connection!=null){
                connection.close();
                System.out.println("connection closed");
            }

        } catch (SQLException e) {
            System.out.println("closeJDBC FAİLED");
            System.out.println(e.getMessage());

        }
    }

    /**
     * tablonun row sayısını elde etme
     */

    static int getRowCount(){

        int row =0;

        try {
            resultSet.last();
            row = resultSet.getRow();

            System.out.println("Satır sayısı : "+row);
            resultSet.beforeFirst();

        } catch (SQLException e) {
            System.out.println("Row count can not get");
            System.out.println(e.getMessage());
        }
        return row;
    }


    /**
    * kolon sayısının elde edilmesi
    */

    static int getColumnCount(){

        int columnCount = 0;

        try {
            columnCount = resultSetMetaData.getColumnCount();
          //  System.out.println("getColumnCount() = " + resultSetMetaData.getColumnCount());

        } catch (SQLException e) {
            System.out.println("MetaData Can Not Get");
        }

        return  columnCount;
    }

    static ResultSetMetaData getResultSetMetaData(){

        try {
            resultSetMetaData = resultSet.getMetaData();
            System.out.println("MetaData Is Got");
        } catch (SQLException e) {
            System.out.println("MetaData con not get");
        }

            return resultSetMetaData;
    }


    /**
     * tüm kolon isimlerini tek bir liste haline getirme
     */

    static List<String> gelAllColumnNameAsList(){
        List<String> columnNameList = new ArrayList<>();


            try {
                for (int i = 1; i <= getColumnCount();  i++) {
                    // System.out.println(" Kolon "+i+" : " +resultSetMetaData.getColumnName(i));
                columnNameList.add(resultSetMetaData.getColumnName(i));
                }
            }
            catch (SQLException e) {
                System.out.println("AllColumnNames can not add to list");
            }
          //  System.out.println("columnNameList.get(i) = " + columnNameList.get(i-1));


        return columnNameList;
    }

    /**
     * parametre olarak row numarası alan,
     * o rowun tüm değerlerini listeye alan metot
     */

    static List<String> getRowDataAsList(int rowNumber){
        List<String> rowDatalist = new ArrayList<>();

        try {
            resultSet.absolute(rowNumber);
            for (int i = 1; i <= getColumnCount(); i++) {
                String cell = resultSet.getString(i);
                rowDatalist.add(cell);

            }
        }
        catch (SQLException e) {
            System.out.println("getRowDataAsList unSuccessful");
        }

        return rowDatalist;
    }

    /**
     *parametre olarak row numarası alan, kolon numarası
     * o hücrenin değerini alan bir metot
     */

    static String getCellData(int rowNumber, int columnIndex){

        String cellData ="";

        try {
            resultSet.absolute(rowNumber);
           cellData=  resultSet.getString(columnIndex);
            resultSet.beforeFirst();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cellData;
    }


    /**
     *parametre olarak row numarası alan, kolon numarası
     * o hücrenin değerini alan bir metot
     */

    static String getCellData(int rowNumber, String columnLabel){

        String cellData ="";

        try {
            resultSet.absolute(rowNumber);
            cellData=  resultSet.getString(columnLabel);
            resultSet.beforeFirst();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cellData;
    }




}

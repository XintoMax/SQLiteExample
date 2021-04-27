package org.horizoncolumbus.hs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        //Connection
        Connection connection = null;
        String url = "jdbc:sqlite:Resources/student.db";

        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Connection success!");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        //Create Table
        String sqlCreateCmd = "create table students " +
                "(id INTEGER, student_name TEXT, grade_level INTEGER, favorite_subject TEXT)";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlCreateCmd);
            System.out.println("Table created successfully!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        //Insert Data
        String sqlInsertCmd = "insert into students values  (6, \"Nana\", 11, \"Programming\")";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlInsertCmd);
            System.out.println("Data inserted successfully!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


        //Query
        String sqlQuery = "select * from students where grade_level = 10";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery(sqlQuery);
            while(resultSet.next()){
                System.out.println(resultSet.getInt("Id") + "\t" +
                        resultSet.getString("student_name") + "\t" +
                        resultSet.getInt("grade_level") + "\t" +
                        resultSet.getString("favorite_subject"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

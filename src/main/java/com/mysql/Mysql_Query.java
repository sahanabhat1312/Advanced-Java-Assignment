/*
12b. Read all the existing records from the table coffee which is from the database test 
and query coffee name starting with ‘D’ in the table.
*/

package com.mysql;

import java.sql.*;
import java.util.Properties;

public class Mysql_Query {

  public static void main(String[] args) {
    try {

      Connection dbConnection = null;

      try {
        String url = "jdbc:mysql://localhost/test";
        Properties info = new Properties();
        info.put("user", "root");
        info.put("password", "userpassword");

        dbConnection = DriverManager.getConnection(url, info);

        if (dbConnection != null) {
          System.out.println("Successfully connected to MySQL database test");
        }

      } catch (SQLException ex) {
        System.out.println("An error occurred while connecting MySQL databse");
        ex.printStackTrace();
      }

      // SQL SELECT query
      String query = "SELECT * FROM coffee where coffee_name like 'D%'";

      // create the java statement
      Statement st = dbConnection.createStatement();

      // execute the query
      ResultSet rs = st.executeQuery(query);

      // iterate through the resultset
      while (rs.next()) {
        int id = rs.getInt("id");
        String coffee_name = rs.getString("coffee_name");
        int price = rs.getInt("price");

        // print results
        System.out.format("\n%d  %s  %d", id, coffee_name, price);
      }

      rs.close();

    } catch (Exception e) {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }
}

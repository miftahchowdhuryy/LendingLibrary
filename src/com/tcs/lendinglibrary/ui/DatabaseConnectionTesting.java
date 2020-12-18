package com.tcs.lendinglibrary.ui;

import java.sql.*;

public class DatabaseConnectionTesting {
    public static void main(String[] args) {

        retrieveResultSet("Select title from Materials");

   /*     changeData("Update Materials set title = ? where id = ?", "A Second Test", 1);

        retrieveResultSet("Select * from Materials");*/

    }

    public static void changeData (String sql, String title, int id){
        try{
            // First we have to load the database driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            // Then I will instantiate connection, statement and resultSet
            // Create a connection to the database server
            try(Connection conn  = DriverManager.getConnection("jdbc:derby://localhost/library")) {

                // Create a Statement object which will allow us to run a piece of sql against that connection
                try (PreparedStatement stm = conn.prepareStatement(sql)) {
                    stm.setString(1, title);
                    stm.setInt(2, id);
                    int results = stm.executeUpdate();
                    System.out.println("Record amended: " + results );
                        }
                    }

        } catch(ClassNotFoundException | SQLException e){
            System.out.println("Something went wrong");
            System.out.println(e);
        }

    }


    public static void retrieveResultSet(String sql) {

        try{
            // First we have to load the database driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            // Then I will instantiate connection, statement and resultSet
            // Create a connection to the database server
            try(Connection conn  = DriverManager.getConnection("jdbc:derby://localhost/library")) {

                // Create a Statement object which will allow us to run a piece of sql against that connection
                try (Statement stm = conn.createStatement()) {

                    // Run a piece of sql and get back a result set
                    try (ResultSet rs = stm.executeQuery(sql)) {

                        /*
                         *   ResultSet - ResultSet object contains a collection of rows.
                         *               By default when you instantiate the object, its position
                         *               would start before the first row.
                         *               .next() - Move to the next row with .next() - you must do this before
                         *               accessing the first row
                         *               getString() / getInteger() - to retrieve the value of the field of the
                         *               current row
                         * */

                        while (rs.next()) {
                            String title = rs.getString("title");
                            System.out.println(title);
                        }
                    }
                }
            }

        } catch(ClassNotFoundException | SQLException e){
            System.out.println("Something went wrong");
            System.out.println(e);
        }

    }
}

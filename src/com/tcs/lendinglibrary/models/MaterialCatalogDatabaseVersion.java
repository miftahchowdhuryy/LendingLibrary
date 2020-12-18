package com.tcs.lendinglibrary.models;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MaterialCatalogDatabaseVersion implements MaterialCatalogInterface{

    public MaterialCatalogDatabaseVersion() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void addMaterial(Material newMaterial) {
        Connection conn = null;
        PreparedStatement stm = null;

        try
        {
            try
            {
                conn  = DriverManager.getConnection("jdbc:derby://localhost/library");

                if(newMaterial instanceof Book)
                {
                    Book newBook = (Book) newMaterial;
                    String sql = "insert into materials (barcode, title, author, isbn, numberofpages, branch, type) values (?, ?, ?, ?, ?, ?, 'BOOK')";
                    stm = conn.prepareStatement(sql);
                    stm.setString(1, newBook.getId());
                    stm.setString(2, newBook.getTitle());
                    stm.setString(3, newBook.getAuthor());
                    stm.setString(4, newBook.getISBN());
                    stm.setInt(5, newBook.getNoOfPages());
                    stm.setString(6, "AnyTown Branch");
                }
                else if (newMaterial instanceof DVD)
                {
                    DVD newDVD = (DVD) newMaterial;
                    String sql = "insert into materials (barcode, title, catalognumber, runningtime, licenced, branch, type) values (?, ?, ?, ?, ?, ?, 'DVD')";
                    stm = conn.prepareStatement(sql);
                    stm.setString(1, newDVD.getId());
                    stm.setString(2, newDVD.getTitle());
                    stm.setString(3, newDVD.getCatalogNo());
                    stm.setInt(4, newDVD.getRunningTime());
                    stm.setBoolean(5, newDVD.isLicenced());
                    stm.setString(6, "AnyTown Branch");
                }

                int results = stm.executeUpdate();
                System.out.println("Records added: " + results);

            }

            finally
            {
                if (stm != null){
                    stm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }

        } catch (SQLException e){
            System.out.println("Something went Wrong!");
            System.out.println(e);
        }
    }

    @Override
    public Map<String, Material> getMaterialMap() {
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;

        try
        {
            try
            {
                conn  = DriverManager.getConnection("jdbc:derby://localhost/library");
                stm = conn.createStatement();
                rs = stm.executeQuery("select * from materials");

                Map <String, Material> allMaterials = new HashMap<>();

                while(rs.next())
                {
                    String materialType = rs.getString("type");
                    if (materialType.equalsIgnoreCase("BOOK")){
                        Book newBook = new Book(rs.getString("barcode"), rs.getString("title"), rs.getString("author"), rs.getString("isbn"), rs.getString("branch"), rs.getInt("numberofpages"));
                        allMaterials.put(rs.getString("barcode"), newBook);
                    }
                    else if (materialType.equalsIgnoreCase("DVD")){
                        DVD newDVD = new DVD(rs.getString("barcode"), rs.getString("title"), rs.getString("branch"), rs.getString("director"), rs.getString("catalogNUmber"), rs.getInt("runningtime"));
                        allMaterials.put(rs.getString("barcode"), newDVD);
                    }

                }
                    return allMaterials;
            }
            finally
            {
                if(rs != null)
                {
                    rs.close();
                }

                if(stm != null)
                {
                    stm.close();
                }

                if(conn != null)
                {
                    conn.close();
                }

            }

        } catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public Material findMaterial(String title) throws MaterialNotFoundException {
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;

        try
        {
            try
            {
                conn  = DriverManager.getConnection("jdbc:derby://localhost/library");
                stm = conn.createStatement();
                rs = stm.executeQuery("select * from materials where title like '%" + title + "%' ");

                if(rs.next())
                {
                    String materialType = rs.getString("type");
                    if (materialType.equalsIgnoreCase("BOOK")){
                        Book newBook = new Book(rs.getString("barcode"), rs.getString("title"), rs.getString("author"), rs.getString("isbn"), rs.getString("branch"), rs.getInt("numberofpages"));
                        return newBook;
                    }
                    else if (materialType.equalsIgnoreCase("DVD")){
                        DVD newDVD = new DVD(rs.getString("barcode"), rs.getString("titile"), rs.getString("branch"), rs.getString("director"), rs.getString("catalogNUmber"), rs.getInt("runningtime"));
                        return newDVD;
                    }
                    else {
                        throw new MaterialNotFoundException("Material not Found");
                    }
                }

                {
                throw new MaterialNotFoundException("Material not Found");
                }
            }
            finally
            {
                if(rs != null)
                {
                    rs.close();
                }

                if(stm != null)
                {
                    stm.close();
                }

                if(conn != null)
                {
                    conn.close();
                }

            }

        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getNumberOfMaterials() {
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;

        try
        {
            try
            {
                conn  = DriverManager.getConnection("jdbc:derby://localhost/library");
                stm = conn.createStatement();
                rs = stm.executeQuery("select count(id) from materials");
                rs.next();
                return rs.getInt(1);
            }
            finally
            {
                if(rs != null)
                {
                    rs.close();
                }

                if(stm != null)
                {
                    stm.close();
                }

                if(conn != null)
                {
                    conn.close();
                    System.out.println("Connection was closed");
                }
                System.out.println("Finally was run");
            }

        } catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
}
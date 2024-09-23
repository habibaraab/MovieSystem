/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication9;

/**
 *
 * @author Dell
 */
import java.sql.*;

public class database {
public static Connection getCon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/movie", "root", "");
            return con;
       }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    
}
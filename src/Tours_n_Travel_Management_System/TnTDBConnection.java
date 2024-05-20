package Tours_n_Travel_Management_System;

import java.sql.*;

public class TnTDBConnection {
    Connection c;
    Statement s;
    public TnTDBConnection(){
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");                             // register the drive class
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/tnt_db?useSSL=false","root","root"); // creating connection string
            s =c.createStatement();
            
           
        }catch(Exception e){
            System.out.println(e);
        }  
    }  
}
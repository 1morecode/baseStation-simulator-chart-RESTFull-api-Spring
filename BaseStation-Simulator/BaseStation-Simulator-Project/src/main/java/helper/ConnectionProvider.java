package helper;

import java.sql.*;

public class ConnectionProvider {
    
    public static Connection con;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/node_data_raw", "root", "");
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
    
    public static void main(String[] args) {
        System.out.println(getConnection()
        );
    }
}

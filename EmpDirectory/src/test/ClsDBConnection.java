package test;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

//import Model.StaffModel;
//import View.LogInView;

public class ClsDBConnection {
    private final String CONNECTION = "jdbc:mysql://localhost:3306/empDirectory";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private static Connection con = null;

    // Static block to load MySQL JDBC driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Get the database connection
    public static Connection getConnection() throws SQLException {
        if (con == null || con.isClosed()) {
            try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empDirectory", "root",  "");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return con;
    }

    // Method to execute a query and return result set
    public ResultSet sqlQuery(String field, String table) throws SQLException {
        Statement stm = getConnection().createStatement();
        return stm.executeQuery("SELECT " + field + " FROM " + table);
    }

    // Method to get primary key for any table
    public String getPrimaryKey(String field, String table, String prefix) throws SQLException {
        ResultSet rs = sqlQuery(field, table);
        int current;
//        if (rs.next()) {
//            current = Integer.parseInt(rs.getString(field).substring(2)) + 1;
//            if(current>0 && current<=9){return prefix +"0000"+current;}
//	           else if(current>9 && current<=99){return prefix +"000"+current;}
//	           else if(current>99 && current<=999){return prefix +"00"+current;}
//	           else if(current>999 && current<=9999){return prefix +"0"+current;}
//	           else if(current>9999 && current<=99999){return prefix +current;}
//        }
//        return prefix + "00001";
        
        List<String> result = new ArrayList<String>();
        while (rs.next()) {
        	result.add(rs.getString(field));
        }
        if(result.size()>0) {
        	System.out.println("result.size : "+ result.size());
        	current = Integer.parseInt(result.get(result.size()-1).toString().substring(2,7)) + 1;
        	System.out.println("current : "+ current);
        	if(current>0 && current<=9){return prefix +"0000"+current;}
	           else if(current>9 && current<=99){return prefix +"000"+current;}
	           else if(current>99 && current<=999){return prefix +"00"+current;}
	           else if(current>999 && current<=9999){return prefix +"0"+current;}
	           else if(current>9999 && current<=99999){return prefix +current;}
        }
        return prefix + "00001";
    }
    
//    error fix start *************************
    public String getPrimaryKey2(String field,String table , String prefix) throws ClassNotFoundException, SQLException
	{
	    ResultSet rs = sqlQuery(field , table);
	    int current;
	    try{
	        ArrayList<String> result = new ArrayList<String>();
	        while(rs.next())
	        {
	            result.add(rs.getString(field));
	        }
	        if(result.size()>0) //10
	        {
	        	
	            current = Integer.parseInt(result.get(result.size()-1).toString().substring(3,10))+1;
	           if(current>0 && current<=9){return prefix +"000000"+current;}
	           else if(current>9 && current<=99){return prefix +"00000"+current;}
	           else if(current>99 && current<=999){return prefix +"0000"+current;}
	           else if(current>999 && current<=9999){return prefix +"000"+current;}
	           else if(current>9999 && current<=99999){return prefix +"00"+current;}
	           else if(current>99999 && current<=999999){return prefix +"0"+current;}
	          else if(current>999999 && current<=9999999){return prefix +current;}
	        }
	    }catch(SQLException ex){//SQL Exception

	        }
	    return prefix+"0000001";//Return
	}
    
   
    
    public static void main(String[] args) {
        try {
        	ClsDBConnection config = new ClsDBConnection();
        	Connection connection = config.getConnection();
        	if(connection!= null) {
        		System.out.println(" connection established successfully.");
        	}
        
    }catch(SQLException e) {
    	e.printStackTrace();
    }
    }
  //total count 
    public static String totalCount(String table) throws SQLException {
        String total_count = null;
        String sql = "SELECT COUNT(*) FROM " + table;
        
        ClsDBConnection db = new ClsDBConnection(); // instantiate to call non-static method
        Connection conn = db.getConnection(); // get the initialized connection
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            total_count = rs.getString(1);
        }
        return total_count;
    }


//  error fix end *******************
}

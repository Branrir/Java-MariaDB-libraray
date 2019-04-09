package gui;

import java.sql.*;

public class SqlIntegration {
	
	/*
	 * MariaDB URL and Driver
	 */
    static final String dbDriver = "org.mariadb.jdbc.Driver";
    static final String dbUrl = "jdbc:mariadb://localhost/library";
    
    /*
     * User credentials
     */
    static final String pass = "123";
    static final String user = "java";
    /*
     * STMT and CONN Variables
     */
    Connection conn = null;
    PreparedStatement prestmt = null;
    
    
public void Insert_games(String name, String jahr, String gerne, String console) {
	
	
	try {
		/*
		 * Driver For MariaDB
		 */
		Class.forName(dbDriver);
		System.out.println("Driver Loaded");
		
		/*
		 * Connection to DB
		 */
		//conn = DriverManager.getConnection(dbUrl, user, pass);
		Connection conn = DriverManager.getConnection(dbUrl+"?user=java&password=123");
		
		/*
		 * Insert of values from GUI in DB
		 */
		
		System.out.println("Inserting Values inside a table");
		String sql = "INSERT INTO games (name, jahr, gerne, console)" +
		        "VALUES (?, ?, ?, ?)";
		
		/*
		 * Create Prepared Statement for SQL
		 */
		prestmt = conn.prepareStatement(sql);
		/*
		 * Insert Strings in prestmt
		 */
		prestmt.setString(1, name);
		prestmt.setString(2, jahr);
		prestmt.setString(3, gerne);
		prestmt.setString(4, console);
		
		prestmt.executeUpdate();
		
		System.out.println("Success");
		gui_tabs.insert_success();
		
 	}
	catch(SQLException se) {
        String error = se.getMessage();
        gui_tabs.error(error);
    } catch(Exception e) {
        //e.printStackTrace();
    } 
	finally {
        try {
            if(prestmt != null)
                conn.close();
        } catch(SQLException e) {
        }
        try {
            if(conn != null)
                conn.close();
        } catch(SQLException se) {
            se.printStackTrace();
        }
	
    }
}



public void Delete_games(String id, String name){
	
	try {
		/*
		 * Driver For MariaDB
		 */
		Class.forName(dbDriver);
		System.out.println("Driver Loaded");
		
		/*
		 * Connection to DB
		 */
		//conn = DriverManager.getConnection(dbUrl, user, pass);
		Connection conn = DriverManager.getConnection(dbUrl+"?user=java&password=123");
		
		/*
		 * Insert of values from GUI in DB
		 */
		
		System.out.println("Delete Values inside a table");
		String sql = "DELETE FROM games " +
		        "WHERE id = ? AND name = ?";
		
		/*
		 * Create Prepared Statement for SQL
		 */
		prestmt = conn.prepareStatement(sql);
		/*
		 * Insert Strings in prestmt
		 */
		prestmt.setString(1, id);
		prestmt.setString(2, name);
		
		prestmt.executeUpdate();
		
		System.out.println("Delete Success");
		gui_tabs.delete_success();
		
		
 	}
	catch(SQLException se) {
       String error =  se.getMessage();
       gui_tabs.error(error);
    } catch(Exception e) {
        //e.printStackTrace();
    } 
	finally {
      try {
        if(prestmt != null)
          conn.close();
        } catch(SQLException e) {
        }
        try {
            if(conn != null)
                conn.close();
        } catch(SQLException se) {
            se.printStackTrace();
        }
	
    }
	
}


/*
 * Return table games as string
 */
public String Return_table_games() {
	String temp = "";
	try {
		/*
		 * Driver For MariaDB
		 */
		Class.forName(dbDriver);
		System.out.println("Driver Loaded");
		
		/*
		 * Connection to DB
		 */
		//conn = DriverManager.getConnection(dbUrl, user, pass);
		Connection conn = DriverManager.getConnection(dbUrl+"?user=java&password=123");
		
		/*
		 * Insert of values from GUI in DB
		 */
		
		System.out.println("Send string to SQL");
		String sql = "SELECT * FROM games;";
		
		/*
		 * Create Prepared Statement for SQL
		 */
		Statement m_Statement = conn.createStatement();
		ResultSet m_ResultSet = m_Statement.executeQuery(sql);
		
		while (m_ResultSet.next()) {
		     temp = temp + "\n" + m_ResultSet.getString(1) + ", " + m_ResultSet.getString(2) + ", "
		          + m_ResultSet.getString(3) + ", " + m_ResultSet.getString(4) + ", " + m_ResultSet.getString(5);
		}
		
	}
	catch(SQLException se) {
	       String error =  se.getMessage();
	       gui_tabs.error(error);
	    } catch(Exception e) {
	        //e.printStackTrace();
	    } 
	finally{
		
	}
	
	
	return temp;
	
	
}


/*
 * Insert entry in table books (String, String, String, String, String)
 */
public void Insert_books(String name, String jahr, String author, String volume, String lang) {
	
	
	try {
		/*
		 * Driver For MariaDB
		 */
		Class.forName(dbDriver);
		System.out.println("Driver Loaded");
		
		/*
		 * Connection to DB
		 */
		//conn = DriverManager.getConnection(dbUrl, user, pass);
		Connection conn = DriverManager.getConnection(dbUrl+"?user=java&password=123");
		
		/*
		 * Insert of values from GUI in DB
		 */
		
		System.out.println("Inserting Values inside a table");
		String sql = "INSERT INTO books (name, author, jahr, volume, lang)" +
		        "VALUES (?, ?, ?, ?, ?)";
		
		/*
		 * Create Prepared Statement for SQL
		 */
		prestmt = conn.prepareStatement(sql);
		/*
		 * Insert Strings in prestmt
		 */
		prestmt.setString(1, name);
		prestmt.setString(2, author);
		prestmt.setString(3, jahr);
		prestmt.setString(4, volume);
		prestmt.setString(5, lang);
		
		prestmt.executeUpdate();
		
		System.out.println("Success");
		gui_tabs.insert_success();
		
 	}
	catch(SQLException se) {
        String error = se.getMessage();
        gui_tabs.error(error);
    } catch(Exception e) {
        //e.printStackTrace();
    } 
	finally {
        try {
            if(prestmt != null)
                conn.close();
        } catch(SQLException e) {
        }
        try {
            if(conn != null)
                conn.close();
        } catch(SQLException se) {
            se.printStackTrace();
        }
	
    }
}


/*
 * Delete entry from books (String id, String name)
 */
public void Delete_books(String id, String name){
	
	try {
		/*
		 * Driver For MariaDB
		 */
		Class.forName(dbDriver);
		System.out.println("Driver Loaded");
		
		/*
		 * Connection to DB
		 */
		//conn = DriverManager.getConnection(dbUrl, user, pass);
		Connection conn = DriverManager.getConnection(dbUrl+"?user=java&password=123");
		
		/*
		 * Insert of values from GUI in DB
		 */
		
		System.out.println("Delete Values inside a table");
		String sql = "DELETE FROM books " +
		        "WHERE id = ? AND name = ?";
		
		/*
		 * Create Prepared Statement for SQL
		 */
		prestmt = conn.prepareStatement(sql);
		/*
		 * Insert Strings in prestmt
		 */
		prestmt.setString(1, id);
		prestmt.setString(2, name);
		
		prestmt.executeUpdate();
		
		System.out.println("Delete Success");
		gui_tabs.delete_success();
		
		
 	}
	catch(SQLException se) {
       String error =  se.getMessage();
       gui_tabs.error(error);
    } catch(Exception e) {
        //e.printStackTrace();
    } 
	finally {
      try {
        if(prestmt != null)
          conn.close();
        } catch(SQLException e) {
        }
        try {
            if(conn != null)
                conn.close();
        } catch(SQLException se) {
            se.printStackTrace();
        }
	
    }
	
}





/*
 * Returns table books as String 
 */
public String Return_table_books() {
	String temp = "";
	try {
		/*
		 * Driver For MariaDB
		 */
		Class.forName(dbDriver);
		System.out.println("Driver Loaded");
		
		/*
		 * Connection to DB
		 */
		//conn = DriverManager.getConnection(dbUrl, user, pass);
		Connection conn = DriverManager.getConnection(dbUrl+"?user=java&password=123");
		
		/*
		 * Insert of values from GUI in DB
		 */
		
		System.out.println("Send string to SQL");
		String sql = "SELECT * FROM books;";
		
		/*
		 * Create Prepared Statement for SQL
		 */
		Statement m_Statement = conn.createStatement();
		ResultSet m_ResultSet = m_Statement.executeQuery(sql);
		
		while (m_ResultSet.next()) {
		     temp = temp + "\n" + m_ResultSet.getString(1) + ", " + m_ResultSet.getString(2) + ", "
		          + m_ResultSet.getString(3) + ", " + m_ResultSet.getString(4) + ", " + m_ResultSet.getString(5)
		          + ", " + m_ResultSet.getString(6);
		}
		
	}
	catch(SQLException se) {
	       String error =  se.getMessage();
	       gui_tabs.error(error);
	    } catch(Exception e) {
	        //e.printStackTrace();
	    } 
	finally{
		
	}
	
	
	return temp;
		
}

}	
	
	
	


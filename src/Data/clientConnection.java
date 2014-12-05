package Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class clientConnection {

	public boolean clientConnection()
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
	
		{
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl = "localhost3306";
			String connectionUser = "test";
			String connectionPassword = "";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM userevents WHERE userID = kakw13ab");
			while (rs.next()) {
			System.out.println(rs.getString("eventID"));	
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
		return false;
	
	}
	
}
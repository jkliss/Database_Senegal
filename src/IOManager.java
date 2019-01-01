import java.sql.Connection;
import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.sql.ResultSet;
// import java.sql.ResultSet;
// import java.sql.Statement;
// import java.util.Vector;
// import java.sql.Date;

public class IOManager {
	public Connection connection;
	public String host;
	public IOManager() {
	 
	}
	
	public boolean connectToMysql(String host, String database, String user, String passwd)	{
	    this.host = host;
		try	{
		//com.microsoft.sqlserver.jdbc.SQLServerDriver
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		//jdbc:mysql://(host=myhost,port=1111,key1=value1)/db
		String connectionCommand = "jdbc:mysql://("+host+",user="+user+",password="+passwd+")/"+database;
		System.out.println("[*] Connection URL: "+connectionCommand+"\n");
		connection = DriverManager.getConnection(connectionCommand);
		return true;
			}	catch (Exception ex)	{
				System.out.println("false, Exception: "+ex);
				return false;
				}
		}
	
	public boolean closeConnection() {
		try {
		System.out.println("\n[*] closing connection..\n");
		connection.close();
		return true;
		}	catch (Exception ex) {
			System.out.println("false, Exception: "+ex);
			return false;
		}
	}

	public Connection getConnection() {
		return connection;
	}
}


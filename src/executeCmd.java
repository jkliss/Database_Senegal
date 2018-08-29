import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// test main-method

public class executeCmd {
	
	public static void main(String[] args) {
		boolean one;
		boolean two;
		
		IOManager con = new IOManager();
		dbQueries queries = new dbQueries();
		// InputStatements input = new InputStatements();
		//,serverTimezone=Europe/Berlin,,uswSSL=false,verifyServerCertificate=false
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String host = "";
		String password = "";
		String user = "";
		try {
			System.out.println("\nMYSQL-USER:");
			user = in.readLine();
			System.out.println("\nMYSQL-HOST:");
			host = in.readLine();
			System.out.println("\nMYSQL-PASSWD:");
			password = in.readLine();
		} catch (IOException ex) {
			
		}
		
		one = con.connectToMysql("host=" + host + ",port=3306,serverTimezone=UTC,useSSL=false,verifyServerCertificate=true,allowPublicKeyRetrieval=true", "mydb", user, password);
		if (one == true) {
			System.out.println("[+] you are connected\n");
			
		}
	
		two = false;
		//two = input.UpdateNurseInfo(con.connection, 18, "Hanyil", "Joplande", false);
		//two = input.UpdateDoctorInfo(con.connection,54,"Franz","Jakob","mimimuma");
		
		if (two == true) {
			System.out.println("[+] input created!");
			
		}
		
		queries.ViewDoctorTable(con.connection);
		queries.ViewNurseTable(con.connection);
		//queries.ViewSpecificDoctorEntryByName(con.connection, "Alexa", "Pina");
		con.closeConnection();
	}

}

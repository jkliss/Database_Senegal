import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

// every method will need a connection object as input - Connection connection
// class should contain request methods (PreparedStatement - Statement)

public class dbQueries {
	
	
	//Method for searching a specific doctor DB entry by the family_name(1) and first_name(2)
	public void ViewSpecificDoctorEntryByName(Connection connection,String family_name, String first_name) {
		
		//check for miscalled options
		
		try {
			System.out.println("[+] Searching doctor entry by full name: "+first_name+" "+family_name);
		} catch (Exception ex) {
			System.out.println("[-] Fail: "+ex);
		}
		
		Statement stmt = null;
		String query = "SELECT * FROM doctor WHERE family_name = \""+family_name+"\" and first_name = \""+first_name+"\"";
		
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int DoctorID = rs.getInt("DoctorID");
				String fa_name = rs.getString("family_name");
				String fi_name = rs.getString("first_name");
				String password = rs.getString("password");
				String timestamp = rs.getString("last_access");
				
				System.out.println("[+] "+DoctorID+"\t"+fa_name+"\t"+fi_name+"\t"+password+"\t"+ timestamp);
			}
			
			stmt.close();
			rs.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
		} 
	}
	public void ViewDoctorTable(Connection connection) {
		
			Statement stmt = null;
			String query = "SELECT * FROM doctor";
			System.out.println("[*] "+query+":");
			
			try {
				
				stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				while (rs.next()) {
					int DoctorID = rs.getInt("DoctorID");
					String family_name = rs.getString("family_name");
					String first_name = rs.getString("first_name");
					String password = rs.getString("password");
					String timestamp = rs.getString("last_access");
					
					System.out.println("[+] "+DoctorID+"\t"+family_name+"\t"+first_name+"\t"+password+"\t"+ timestamp);
				}
				
				// is it usefull to close the object? any autoclose option?
				stmt.close();
				rs.close();
				
			} catch (Exception ex) {
				System.out.println(ex);
			} 
	}
	
	public void ViewNurseTable(Connection connection) {
		Statement stmt = null;
		String query = "SELECT * FROM nurse";
		System.out.println("[*] "+query+":");
		
		try {
			
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				int NurseID = rs.getInt("NurseID");
				String family_name = rs.getString("family_name");
				String first_name = rs.getString("first_name");
				boolean discretion_contract = rs.getBoolean("discretion_contract");
				
				System.out.println("[+] "+NurseID+"\t"+family_name+"\t"+first_name+"\t"+discretion_contract+"\t");
			}
			
			// is it usefull to close the object? any autoclose option?
			stmt.close();
			rs.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
		} 
	}
}

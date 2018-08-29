import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;

// class should contain update methods - INSERT INTO table(atrr1,atrr2) VALUES(?,?)


public class InputStatements {
	
	// method for creating a new doctor entry 
		public boolean UpdateDoctorInfo(Connection connection, int DoctorID, String family_name, String first_name, String password) {
			
			// check for miscalled options
			try {
				System.out.println("[+] create a new DB entry for \"doctor\"");
				System.out.println(" ID: "+DoctorID+"\n"+"family_name: "+family_name+"\n"+first_name+"\n"+password+"\n");
			} catch (Exception ex) {
				System.out.println("[-] Fail: "+ex);
			}
			
			// insert prepared statement 
			try {
				
				Date date = new Date();
	            java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
	            
				PreparedStatement stmt = connection.prepareStatement("INSERT INTO doctor(DoctorID,family_name,first_name,password,last_access) "+ "VALUES (?,?,?,?,?)");
				stmt.setInt(1, DoctorID);
				stmt.setString(2, family_name);
				stmt.setString(3, first_name);
				stmt.setString(4, password);
				stmt.setTimestamp(5, sqlTime);
				stmt.executeUpdate();
				stmt.close();
				System.out.println("---------------------------------------------------");
				
				return true;
				
			} catch (Exception ex) {
				
				System.out.println("Exception: "+ex);
				return false;
			}
		}
		
		// method for creating a new nurse entry
		public boolean UpdateNurseInfo(Connection connection, int NurseID, String family_name, String first_name, boolean discretion_contract) {
			try {
				System.out.println("[+] Create a new DB entry for \"nurse\":");
				System.out.println(" ID: "+NurseID+"\n family_name: "+family_name+"\n first_name: "+first_name+"\n discretion contract: "+discretion_contract);
			} catch (Exception ex) {
				System.out.println("[-] Fail: "+ex);
			}
			
			try {
				
				PreparedStatement stmt = connection.prepareStatement("INSERT INTO nurse(NurseID,family_name,first_name,discretion_contract) "+ "VALUES (?,?,?,?)");
				stmt.setInt(1, NurseID);
				stmt.setString(2, family_name);
				stmt.setString(3, first_name);
				stmt.setBoolean(4, discretion_contract);
				stmt.executeUpdate();
				stmt.close();
				
				System.out.println("---------------------------------------------------");
				return true;
				
			} catch (Exception ex) {
				
				System.out.println("Exception: "+ex);
				return false;
			}
			
		}
}

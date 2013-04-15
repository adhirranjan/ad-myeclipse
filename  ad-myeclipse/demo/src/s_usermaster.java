
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class s_usermaster
{
		private int UesrId;  
	    private String UserName;  
	    private String LoginName;  
	    private String EmailId;  
	    private String Password;  
	    s_usermaster() { }  
	    s_usermaster(int UesrId)  
	    {  
	        this.UesrId = UesrId;  
	    }  
	    s_usermaster(int UesrId, String UserName, String EmailId,String LoginName,String Password)  
	    {  
	        this.UesrId = UesrId;  
	        this.UserName = UserName;  
	        this.LoginName = LoginName;  
	        this.EmailId = EmailId;  
	        this.Password= Password;
	    }  
	      
	    public int getUesrId() 
	    {  
	        return UesrId;  
	    }  
	    public void setUesrId(int UesrId) 
	    {  
	        this.UesrId = UesrId;  
	    }  
	    public String getUserName() 
	    {  
	        return UserName;  
	    }  
	    public void setUserName(String UserName) 
	    {  
	        this.UserName = UserName;  
	    }  
	    public String getLoginName() 
	    {  
	        return LoginName;  
	    }  
	    public void setLoginName(String LoginName) 
	    {  
	        this.LoginName = LoginName;  
	    }  
	    public String getEmailId() 
	    {  
	        return EmailId;  
	    }  
	    public void setEmailId(String EmailId) 
	    {  
	        this.EmailId = EmailId;  
	    }
	    public String getPassword() 
	    {  
	        return Password;  
	    }  
	    public void setPassword(String Password) 
	    {  
	        this.Password= Password;  
	    }
	 
	    public ResultSet fetchRecords(Connection conn) throws SQLException, ClassNotFoundException  
		{  
			String query = "SELECT * FROM users";  
			Statement st =conn.createStatement();  
			ResultSet rs = st.executeQuery(query);  
		    return rs;  
		}  
		public int insertRecords(Connection conn, s_usermaster emp) throws ClassNotFoundException, SQLException  
		{  
		    String query = "INSERT INTO s_usermaster(UserName,EmailId,LoginName,Password) VALUES ('"+emp.getUserName()+"','"+emp.getLoginName()+"','"+emp.getEmailId()+"','"+emp.getPassword()+"')";  
		    Statement st = conn.createStatement();  
		    int rs = st.executeUpdate(query);  
		    return rs;  
		}  
		public int updateRecord(Connection conn, s_usermaster emp) throws ClassNotFoundException, SQLException  
		{  
		    String query = "UPDATE s_usermaster SET UserName ='"+emp.getUserName()+"', EmailId = '"+emp.getEmailId()+"', LoginName = '"+emp.getLoginName()+"' WHERE UesrId = "+emp.getUesrId()+"";  
		    Statement st = conn.createStatement();  
		    int rs = st.executeUpdate(query);  
		    return rs;  
		}  
		public int deleteRecord(Connection conn, s_usermaster emp) throws ClassNotFoundException, SQLException  
		{  
		    String query = "DELETE FROM s_usermaster WHERE UesrId = '"+emp.getUesrId()+"'";  
		    Statement st = conn.createStatement();  
		    int rs = st.executeUpdate(query);  
		    return rs;  
		}
		public ResultSet authenticate(Connection conn,s_usermaster emp) throws SQLException, ClassNotFoundException  
		{  
				String query = "SELECT * FROM s_usermaster where LoginName = '" +emp.getLoginName()+" and Password='" +emp.getPassword();  
				Statement st =conn.createStatement();  
				ResultSet rs = st.executeQuery(query);  
			    return rs;  
		 }  

	
}
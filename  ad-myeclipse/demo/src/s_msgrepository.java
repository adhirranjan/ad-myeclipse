
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class s_msgrepository
{
	
	
	
		private int msgRepositoryId;  
	    private int UserId;  
	    private String Path;  
	    private String Title;  
	      
	    s_msgrepository() { }  
	    s_msgrepository(int msgRepositoryId)  
	    {  
	        this.msgRepositoryId =msgRepositoryId;  
	    }  
	    s_msgrepository(int msgRepositoryId, int UserId, String Title,String Path)  
	    {  
	        this.msgRepositoryId =msgRepositoryId;  
	        this.UserId = UserId;  
	        this.Path = Path;  
	        this.Title = Title;  
	    }  
	      
	    public int getmsgRepositoryId() 
	    {  
	        return msgRepositoryId;  
	    }  
	    public void setmsgRepositoryId(int msgRepositoryId) 
	    {  
	        this.msgRepositoryId =msgRepositoryId;  
	    }  
	    public int getUserId() 
	    {  
	        return UserId;  
	    }  
	    public void setUserId(int UserId) 
	    {  
	        this.UserId = UserId;  
	    }  
	    public String getPath() 
	    {  
	        return Path;  
	    }  
	    public void setPath(String Path) 
	    {  
	        this.Path = Path;  
	    }  
	    public String getTitle() 
	    {  
	        return Title;  
	    }  
	    public void setTitle(String Title) 
	    {  
	        this.Title = Title;  
	    }
	    public ResultSet fetchRecords(Connection conn) throws SQLException, ClassNotFoundException  
		{  
			String query = "SELECT * FROM s_msgrepository";  
			Statement st =conn.createStatement();  
			ResultSet rs = st.executeQuery(query);  
		    return rs;  
		}  
		public int insertRecords(Connection conn, s_msgrepository emp) throws ClassNotFoundException, SQLException  
		{  
		    String query = "INSERT INTO s_msgrepository(UserId,Path,Title) VALUES ('"+emp.getUserId()+"','"+emp.getPath()+"','"+emp.getTitle()+"')";  
		    Statement st = conn.createStatement();  
		    int rs = st.executeUpdate(query);  
		    return rs;  
		}  
		public int updateRecord(Connection conn, s_msgrepository emp) throws ClassNotFoundException, SQLException  
		{  
		    String query = "UPDATE s_msgrepository SET UserId ='"+emp.getUserId()+"', Title = '"+emp.getTitle()+"', Path = '"+emp.getPath()+"' WHERE msgRepositoryId = "+emp.getmsgRepositoryId()+"";  
		    Statement st = conn.createStatement();  
		    int rs = st.executeUpdate(query);  
		    return rs;  
		}  
		public int deleteRecord(Connection conn, s_msgrepository emp) throws ClassNotFoundException, SQLException  
		{  
		    String query = "DELETE FROM s_msgrepository WHERE msgRepositoryId = "+emp.getmsgRepositoryId()+"";  
		    Statement st = conn.createStatement();  
		    int rs = st.executeUpdate(query);  
		    return rs;  
		}
		public ResultSet GetMsgData(Connection conn,s_msgrepository emp) throws SQLException, ClassNotFoundException  
		{  
				String query = "SELECT * FROM s_msgrepository where UserId= " +emp.getUserId();  
				Statement st =conn.createStatement();  
				ResultSet rs = st.executeQuery(query);  
			    return rs;  
		 }  
	
}
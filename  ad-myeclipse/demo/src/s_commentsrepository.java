import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class s_commentsrepository
{
	
	
	
		private int commentsRepositoryId;  
	    private int UserId;  
	    private String Path;  
	    private String Title;  
	      
	    s_commentsrepository() { }  
	    s_commentsrepository(int commentsRepositoryId)  
	    {  
	        this.commentsRepositoryId =commentsRepositoryId;  
	    }  
	    s_commentsrepository(int commentsRepositoryId, int UserId, String Title,String Path)  
	    {  
	        this.commentsRepositoryId =commentsRepositoryId;  
	        this.UserId = UserId;  
	        this.Path = Path;  
	        this.Title = Title;  
	    }  
	      
	    public int getcommentsRepositoryId() 
	    {  
	        return commentsRepositoryId;  
	    }  
	    public void setcommentsRepositoryId(int commentsRepositoryId) 
	    {  
	        this.commentsRepositoryId =commentsRepositoryId;  
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
			String query = "SELECT * FROM s_commentsrepository";  
			Statement st =conn.createStatement();  
			ResultSet rs = st.executeQuery(query);  
		    return rs;  
		}  
		public int insertRecords(Connection conn, s_commentsrepository emp) throws ClassNotFoundException, SQLException  
		{  
		    String query = "INSERT INTO s_commentsrepository(UserId,Path,Title) VALUES ('"+emp.getUserId()+"','"+emp.getPath()+"','"+emp.getTitle()+"')";  
		    Statement st = conn.createStatement();  
		    int rs = st.executeUpdate(query);  
		    return rs;  
		}  
		public int updateRecord(Connection conn, s_commentsrepository emp) throws ClassNotFoundException, SQLException  
		{  
		    String query = "UPDATE s_commentsrepository SET UserId ='"+emp.getUserId()+"', Title = '"+emp.getTitle()+"', Path = '"+emp.getPath()+"' WHERE commentsRepositoryId = "+emp.getcommentsRepositoryId()+"";  
		    Statement st = conn.createStatement();  
		    int rs = st.executeUpdate(query);  
		    return rs;  
		}  
		public int deleteRecord(Connection conn, s_commentsrepository emp) throws ClassNotFoundException, SQLException  
		{  
		    String query = "DELETE FROM s_commentsrepository WHERE commentsRepositoryId = "+emp.getcommentsRepositoryId()+"";  
		    Statement st = conn.createStatement();  
		    int rs = st.executeUpdate(query);  
		    return rs;  
		}
		public ResultSet GetCommentsData(Connection conn,s_commentsrepository emp) throws SQLException, ClassNotFoundException  
		{  
				String query = "SELECT * FROM s_commentsrepository where UserId= " +emp.getUserId();  
				Statement st =conn.createStatement();  
				ResultSet rs = st.executeQuery(query);  
			    return rs;  
		 }  
	
}
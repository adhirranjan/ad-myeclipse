
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class s_songrepository
{
	
	
	
		private int songRepositoryId;  
	    private int UserId;  
	    private String Path;  
	    private String Title;  
	      
	    s_songrepository() { }  
	    s_songrepository(int songRepositoryId)  
	    {  
	        this.songRepositoryId =songRepositoryId;  
	    }  
	    s_songrepository(int songRepositoryId, int UserId, String Title,String Path)  
	    {  
	        this.songRepositoryId =songRepositoryId;  
	        this.UserId = UserId;  
	        this.Path = Path;  
	        this.Title = Title;  
	    }  
	      
	    public int getsongRepositoryId() 
	    {  
	        return songRepositoryId;  
	    }  
	    public void setsongRepositoryId(int songRepositoryId) 
	    {  
	        this.songRepositoryId =songRepositoryId;  
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
			String query = "SELECT * FROM s_songrepository";  
			Statement st =conn.createStatement();  
			ResultSet rs = st.executeQuery(query);  
		    return rs;  
		}  
		public int insertRecords(Connection conn, s_songrepository emp) throws ClassNotFoundException, SQLException  
		{  
		    String query = "INSERT INTO s_songrepository(UserId,Path,Title) VALUES ('"+emp.getUserId()+"','"+emp.getPath()+"','"+emp.getTitle()+"')";  
		    Statement st = conn.createStatement();  
		    int rs = st.executeUpdate(query);  
		    return rs;  
		}  
		public int updateRecord(Connection conn, s_songrepository emp) throws ClassNotFoundException, SQLException  
		{  
		    String query = "UPDATE s_songrepository SET UserId ='"+emp.getUserId()+"', Title = '"+emp.getTitle()+"', Path = '"+emp.getPath()+"' WHERE songRepositoryId = "+emp.getsongRepositoryId()+"";  
		    Statement st = conn.createStatement();  
		    int rs = st.executeUpdate(query);  
		    return rs;  
		}  
		public int deleteRecord(Connection conn, s_songrepository emp) throws ClassNotFoundException, SQLException  
		{  
		    String query = "DELETE FROM s_songrepository WHERE songRepositoryId = "+emp.getsongRepositoryId()+"";  
		    Statement st = conn.createStatement();  
		    int rs = st.executeUpdate(query);  
		    return rs;  
		}
		public ResultSet GetSongData(Connection conn,s_songrepository emp) throws SQLException, ClassNotFoundException  
		{  
				String query = "SELECT * FROM s_songrepository where UserId= " +emp.getUserId();  
				Statement st =conn.createStatement();  
				ResultSet rs = st.executeQuery(query);  
			    return rs;  
		 }  
	
}
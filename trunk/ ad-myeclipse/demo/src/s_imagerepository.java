
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class s_imagerepository
{
	
	
	
		private int ImageRepositoryId;  
	    private int UserId;  
	    private String Path;  
	    private String Title;  
	      
	    s_imagerepository() { }  
	    s_imagerepository(int ImageRepositoryId)  
	    {  
	        this.ImageRepositoryId =ImageRepositoryId;  
	    }  
	    s_imagerepository(int ImageRepositoryId, int UserId, String Title,String Path)  
	    {  
	        this.ImageRepositoryId =ImageRepositoryId;  
	        this.UserId = UserId;  
	        this.Path = Path;  
	        this.Title = Title;  
	    }  
	      
	    public int getImageRepositoryId() 
	    {  
	        return ImageRepositoryId;  
	    }  
	    public void setImageRepositoryId(int ImageRepositoryId) 
	    {  
	        this.ImageRepositoryId =ImageRepositoryId;  
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
			String query = "SELECT * FROM s_imagerepository";  
			Statement st =conn.createStatement();  
			ResultSet rs = st.executeQuery(query);  
		    return rs;  
		}  
		public int insertRecords(Connection conn, s_imagerepository emp) throws ClassNotFoundException, SQLException  
		{  
		    String query = "INSERT INTO s_imagerepository(UserId,Path,Title) VALUES ('"+emp.getUserId()+"','"+emp.getPath()+"','"+emp.getTitle()+"')";  
		    Statement st = conn.createStatement();  
		    int rs = st.executeUpdate(query);  
		    return rs;  
		}  
		public int updateRecord(Connection conn, s_imagerepository emp) throws ClassNotFoundException, SQLException  
		{  
		    String query = "UPDATE s_imagerepository SET UserId ='"+emp.getUserId()+"', Title = '"+emp.getTitle()+"', Path = '"+emp.getPath()+"' WHERE ImageRepositoryId = "+emp.getImageRepositoryId()+"";  
		    Statement st = conn.createStatement();  
		    int rs = st.executeUpdate(query);  
		    return rs;  
		}  
		public int deleteRecord(Connection conn, s_imagerepository emp) throws ClassNotFoundException, SQLException  
		{  
		    String query = "DELETE FROM s_imagerepository WHERE ImageRepositoryId = "+emp.getImageRepositoryId()+"";  
		    Statement st = conn.createStatement();  
		    int rs = st.executeUpdate(query);  
		    return rs;  
		}
		public ResultSet GetImageData(Connection conn,s_imagerepository emp) throws SQLException, ClassNotFoundException  
		{  
				String query = "SELECT * FROM s_imagerepository where UserId= " +emp.getUserId();  
				Statement st =conn.createStatement();  
				ResultSet rs = st.executeQuery(query);  
			    return rs;  
		 }  
	
}
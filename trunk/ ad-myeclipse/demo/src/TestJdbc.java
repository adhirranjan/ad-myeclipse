import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestJdbc {
	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		/* for type 4 drivers */

		String user = "root";
		String pass = "root";
		String url = "jdbc:mysql://localhost:3306/test";
		String conn = "com.mysql.jdbc.Driver";
		Class.forName(conn);
		Connection con = DriverManager.getConnection(url, user, pass);

		/* end of connection */

		return con;
	}
	
	public static String resultSetToJson(ResultSet rs) throws Exception{
		ResultSetMetaData rsMeta=null;
		StringBuilder sb=new StringBuilder();
		try {
			rsMeta = rs.getMetaData();
			sb.append("{table:{rows:[");
			while (rs.next()) {		
				sb.append("{");
				for(int i=1;i<rsMeta.getColumnCount();i++){
					sb.append(String.format("'%s':'%s',", rsMeta.getColumnName(i),rs.getString(rsMeta.getColumnName(i)) ));
				}
				if(sb.toString().lastIndexOf(",") == sb.length()-1){
					sb.replace(sb.length()-1, sb.length(), "");				
				}
				sb.append("},");
			}
			if(sb.toString().lastIndexOf(",") == sb.length()-1){
				sb.replace(sb.length()-1, sb.length(), "");				
			}
			sb.append("]}}");
		} catch (SQLException exSql) {
			exSql.printStackTrace();
			throw(exSql);
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw(ex);
		}
		return sb.toString();
	}
	
	public static void main(String args[]) throws SQLException,
			ClassNotFoundException, IOException {
		System.out.println("-----------------------");
		s_usermaster user = new s_usermaster();

		List<s_usermaster> userList = new ArrayList<s_usermaster>();
		ResultSet rs = user.fetchRecords(getConnection());
		
		try {
			System.out.println(resultSetToJson(rs));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		while (rs.next()) {
			user = new s_usermaster();
			user.setLoginName(rs.getString("email"));
			userList.add(user);
		}
		//System.out.println(userList.get(0).getLoginName());

	 
	}
}

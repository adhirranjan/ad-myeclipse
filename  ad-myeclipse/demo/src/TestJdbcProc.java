import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class TestJdbcProc {
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

	public static void main(String args[]) throws SQLException,
			ClassNotFoundException, IOException {

		System.out.println("-----------------------");
		String res = "";
		try {
			Connection con = getConnection();
			CallableStatement cs = null;
			cs = con.prepareCall("{call pr_authenticateUser(?,?,?,?)}");
			cs.setString("p_email", "a@a.com");
			cs.setString("p_pwd", "apwd");
			cs.setString("p_deviceid", "a@a.com");
			// cs.registerOutParameter("p_out_user_id", Types.VARCHAR);
			cs.registerOutParameter("p_out_error", Types.VARCHAR);

			ResultSet rs = cs.executeQuery();

			System.out.println("p_out_error: " + cs.getString("p_out_error"));

			// System.out.println("p_out_user_id: " +
			// cs.getString("p_out_user_id"));
			if (cs.getString("p_out_error") != null) {
				res = String.format("{'error':'%s'}",
						cs.getString("p_out_error"));
			} else {
				rs.next();
				res = String.format("{'user_id':'%s', 'name':'%s'}",
						rs.getString("user_id"), rs.getString("username"));
			}
			// s_usermaster user = new s_usermaster();
			//
			// List<s_usermaster> userList = new ArrayList<s_usermaster>();
			// ResultSet rs = user.fetchRecords(getConnection());
			// while (rs.next()) {

			// System.out.println("email: " + rs.getString("email"));
			// }
			//
			// System.out.println(userList.get(0).getLoginName());

		} catch (SQLException sqlex) {
			res = String.format("{'error':'%s'}", sqlex.getMessage());
			System.out.println("SQLException: " + sqlex.getMessage()
					+ sqlex.getSQLState());
		} catch (Exception ex) {
			res = String.format("{'error':'%s'}", ex.getMessage());
			System.out.println(ex.getMessage());
		}
		System.out.println(res);
		System.out.println("press any key to exit...");
		System.in.read();

	}
}

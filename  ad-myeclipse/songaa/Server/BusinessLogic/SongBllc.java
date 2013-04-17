import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class SongBllc {
	public static String getFavorites(String user_id) {
		String res = "";
		try {
			Connection con = DbContext.getConnection();

			CallableStatement cs = null;
			cs = con.prepareCall("{call pr_myfav(?,?)}");
			cs.setString("p_userid", user_id); //
			cs.registerOutParameter("p_out_error", Types.VARCHAR);

			ResultSet rs = cs.executeQuery();

			System.out.println("p_out_error: " + cs.getString("p_out_error"));

			if (cs.getString("p_out_error") != null) {
				res = String.format("{'error':'%s'}",
						cs.getString("p_out_error"));
			} else {
				res = DbContext.resultSetToJson(rs);
			}

		} catch (SQLException sqlex) {
			res = String.format("{'error':'%s'}", sqlex.getMessage());
			System.out.println("SQLException: " + sqlex.getMessage()
					+ sqlex.getSQLState());
		} catch (Exception ex) {
			res = String.format("{'error':'%s'}", ex.getMessage());
			System.out.println(ex.getMessage());
		}
		System.out.println("res: " + res);
		return res;
	}

	public static String getSongUpdates(String user_id) {
		String res = "";
		try {
			Connection con = DbContext.getConnection();

			CallableStatement cs = null;
			cs = con.prepareCall("{call pr_getSongUpdates(?,?)}");
			cs.setString("p_userid", user_id); //
			cs.registerOutParameter("p_out_error", Types.VARCHAR);

			ResultSet rs = cs.executeQuery();

			System.out.println("p_out_error: " + cs.getString("p_out_error"));

			if (cs.getString("p_out_error") != null) {
				res = String.format("{'error':'%s'}",
						cs.getString("p_out_error"));
			} else {
				res = DbContext.resultSetToJson(rs);
			}

		} catch (SQLException sqlex) {
			res = String.format("{'error':'%s'}", sqlex.getMessage());
			System.out.println("SQLException: " + sqlex.getMessage()
					+ sqlex.getSQLState());
		} catch (Exception ex) {
			res = String.format("{'error':'%s'}", ex.getMessage());
			System.out.println(ex.getMessage());
		}
		System.out.println("res: " + res);
		return res;
	}
}

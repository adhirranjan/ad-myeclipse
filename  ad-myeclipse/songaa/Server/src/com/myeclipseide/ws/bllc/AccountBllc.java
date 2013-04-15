package com.myeclipseide.ws.bllc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.myeclipseide.ws.dalc.DbContext;

public class AccountBllc {
	public static String authenticate(String email, String pwd, String deviceid) {
		String res = "";
		try {
			Connection con = DbContext.getConnection();
			CallableStatement cs = null;
			cs = con.prepareCall("{call pr_authenticateUser(?,?,?,?)}");
			cs.setString("p_email", email);
			cs.setString("p_pwd", pwd);
			cs.setString("p_deviceid", deviceid);
			// cs.registerOutParameter("p_out_user_id", Types.VARCHAR);
			cs.registerOutParameter("p_out_error", Types.VARCHAR);

			// System.out.println("p_out_user_id: " +
			// cs.getString("p_out_user_id"));
			ResultSet rs = cs.executeQuery();
			System.out.println("p_out_error: " + cs.getString("p_out_error"));
			if (cs.getString("p_out_error") != null) {
				res = String.format("{'error':'%s'}",
						cs.getString("p_out_error"));
			} else {
				rs.next();
				res = String.format("{'user_id':'%s', 'name':'%s'}",
						rs.getString("user_id"), rs.getString("username"));
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

	public static String register(String email, String pwd, String name) {
		String res = "";
		try {
			Connection con = DbContext.getConnection();
			CallableStatement cs = null;
			cs = con.prepareCall("{call pr_regUser(?,?,?,?)}");
			cs.setString("p_email", email);
			cs.setString("p_pwd", pwd);
			cs.setString("p_name", name);

			cs.registerOutParameter("p_out_error", Types.VARCHAR);

			cs.executeQuery();

			if (cs.getString("p_out_error") != null) {
				res = String.format("{'error':'%s'}",
						cs.getString("p_out_error"));
			} else {
				res = "{'status':'ok'}";
			}

		} catch (SQLException sqlex) {
			res = String.format("{'error':'%s'}", sqlex.getMessage());
			System.out.println("SQLException: " + sqlex.getMessage()
					+ sqlex.getSQLState());
		} catch (Exception ex) {
			res = String.format("{'error':'%s'}", ex.getMessage());
			System.out.println(ex.getMessage());
		}
		return res;
	}
}

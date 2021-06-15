package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Template;

public class TemplateDao {
	public List<Template> Template(){
		Connection conn = null;
		List<Template> Template = new ArrayList<Template>();

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-4/QAsystem ", "sa", "sa");

			String sql = "SELECT * FROM M_TEMPLATE";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				Template temp = new Template(
						rs.getInt("TEMP_ID"),
						rs.getString("TEMP_CONTENTS")
						);
				Template.add(temp);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			Template = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			Template = null;
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					Template = null;
				}
			}
		}
		return Template;
	}
}

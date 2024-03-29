package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Answer;

public class AnswersDao {
	public List<Answer> List(int q_id){
		Connection conn = null;
		List<Answer> AnswerList = new ArrayList<Answer>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-4/QAsystem", "sa", "sa");

			// SQL文を準備する
			String sql = "SELECT D_ANSWERS.ANS_CONTENTS, M_USERS.USER_NAME "
					+ "FROM D_ANSWERS "
					+ "INNER JOIN M_USERS "
					+ "ON D_ANSWERS.USER_ID = M_USERS.USER_ID "
					+ "WHERE D_ANSWERS.Q_ID = ? "
					+ "ORDER BY D_ANSWERS.ANS_DATE";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, q_id);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				Answer card = new Answer(
						rs.getString("ANS_CONTENTS"),
						rs.getString("USER_NAME")
						);
				AnswerList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return AnswerList;
	}

	public boolean insert(Answer card) {
		Connection conn = null;
		boolean result = false;

		try {
			Class.forName("org.h2.Driver");

			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-4/QAsystem", "sa", "sa");

			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("MAX(ANS_ID) + 1 ");
			sb.append("AS MAXID ");
			sb.append("FROM ");
			sb.append("D_ANSWERS");

			//maxIDを初期化
			int maxID = 0;

			try (PreparedStatement ps = conn.prepareStatement(sb.toString())) {
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						maxID = rs.getInt(1);
						if (maxID == 0) {
							maxID = maxID + 1;
						}
					}
					System.out.println("最大値:" + maxID);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			String sql = "INSERT INTO D_ANSWERS (ANS_ID, Q_ID, ANS_CONTENTS, USER_ID, ANS_DATE) "
					+ "VALUES(?, ?, ?, ?, CURDATE())";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1,  maxID);
			pStmt.setInt(2, card.getQ_id());
			if(card.getAns_contents() != null && !card.getAns_contents().equals("")) {
				pStmt.setString(3, card.getAns_contents());
			}
			else {
				pStmt.setString(3, null);
			}
			if(card.getUser_id() != null && !card.getUser_id().equals("")) {
				pStmt.setString(4, card.getUser_id());
			}
			else {
				pStmt.setString(4, null);
			}

			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}

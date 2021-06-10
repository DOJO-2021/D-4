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
	public List<Answer> List(Answer param){
		Connection conn = null;
		List<Answer> AnswerList = new ArrayList<Answer>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-4/QAsystem ", "sa", "sa");

			// SQL文を準備する
			String sql = "SELECT d_a.ANS_CONTENTS, m_u.USER_NAME, d_a.ANS_DATE  FROM D_ANSWERS d_a"
					+ "INNER JOIN M_USERS m_u ON d_a.USER_ID = m_u.USERID "
					+ "WHERE Q_ID = ? ORDER BY ANS_DATE";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){

			}
		}
	}

	public boolean insert(Answer card) {
		Connection conn = null;
		boolean result = false;

		try {
			Class.forName("org.h2.Driver");

			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-4/QAsystem ", "sa", "sa");

			String sql = "INSERT INTO D_ANSWERS(ANS_ID,Q_ID,ANS_CONTENTS,"
					+ "USER_ID,ANS_DATE) SELECT '', Q_ID, ?, USER_ID, sysdate"
					+ "FROM D_QUESTIONS";
			PreparedStatement pStmt = conn.prepareStatement(sql);
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

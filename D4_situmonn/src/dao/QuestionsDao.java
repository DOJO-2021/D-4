package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
//import java.util.Date;
import java.sql.Date;

import model.Question;

public class QuestionsDao {

	//質問一覧検索時(解決済み)
	//引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Question> selectQListS(Question param) {
		Connection conn = null;
		List<Question> QList = new ArrayList<Question>();

		try {
			//JDBCドライバ読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-4/QAsystem", "sa", "sa");

			//SQL文を準備
			String sql = "select D_QUESTIONS.Q_ID, D_QUESTIONS.Q_TITLE, D_QUESTIONS.Q_CONTENTS, "
					+ "D_QUESTIONS.Q_TAG01, D_QUESTIONS.Q_TAG02, D_QUESTIONS.Q_TAG03, D_QUESTIONS.Q_TAG04, D_QUESTIONS.Q_TAG05, "
					+ "D_QUESTIONS.USER_ID, D_QUESTIONS.Q_FILE, D_QUESTIONS.Q_DATE, D_QUESTIONS.DONE_TAG, D_QUESTIONS.COUNTER, M_USERS.USER_NAME "
					+ "from D_QUESTIONS "
					+ "inner join M_USERS "
					+ "on M_USERS.USER_ID = D_QUESTIONS.USER_ID "
					+ "where D_QUESTIONS.Q_TAG01"
					+ "order by Q_DATE desc";
		}
	}

	//質問一覧検索時(未解決)
	//引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Question> selectQListU(Question param) {

	}


	//検索一覧から質問詳細移動時 & マイページから質問詳細移動時用
	//引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Question> selectQDetail(String q_id) {
		Connection conn = null;
		List<Question> QEdit = new ArrayList<Question>();

		try {
			//JDBCドライバ読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-4/QAsystem", "sa", "sa");

			//SQL文を準備
			String sql = "select D_QUESTIONS.Q_ID, D_QUESTIONS.Q_TITLE, D_QUESTIONS.Q_CONTENTS, "
					+ "D_QUESTIONS.Q_TAG01, D_QUESTIONS.Q_TAG02, D_QUESTIONS.Q_TAG03, D_QUESTIONS.Q_TAG04, D_QUESTIONS.Q_TAG05, "
					+ "D_QUESTIONS.USER_ID, D_QUESTIONS.Q_FILE, D_QUESTIONS.Q_DATE, D_QUESTIONS.DONE_TAG, M_USERS.USER_NAME "
					+ "from D_QUESTIONS "
					+ "inner join M_USERS "
					+ "on M_USERS.USER_ID = D_QUESTIONS.USER_ID "
					+ "where Q_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setString(1, q_id);

			//SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//結果表をコレクションにコピーする
			while (rs.next()) {
				Question QEditList = new Question(
						rs.getInt("Q_ID"),
						rs.getString("Q_TITLE"),
						rs.getString("Q_CONTENTS"),
						rs.getString("Q_TAG01"),
						rs.getString("Q_TAG02"),
						rs.getString("Q_TAG03"),
						rs.getString("Q_TAG04"),
						rs.getString("Q_TAG05"),
						rs.getString("USER_ID"),
						rs.getString("Q_FILE"),
						rs.getDate("Q_DATE"),
						rs.getInt("DONE_TAG"),
						rs.getInt("COUNTER"),
						rs.getString("USER_NAME")
						);
				QEdit.add(QEditList);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			QEdit = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			QEdit = null;
		}
		finally {
			//データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					QEdit = null;
				}
			}
		}

		//結果を返す
		return QEdit;
	}

	//質問投稿用
	//引数paramで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insertQRecord(Question param) {
		Connection conn = null;
		boolean insertResult = false;

		try {

			//JDBCドライバ読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-4/QAsystem", "sa", "sa");

			//MaxIDを取ってくる
			//SQL文の準備
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("MAX(Q_ID) + 1 ");
			sb.append("AS MAXID ");
			sb.append("FROM ");
			sb.append("D_QUESTIONS");

			//maxIDを初期化
			int maxID = 0;

			try (PreparedStatement ps = conn.prepareStatement(sb.toString())) {
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						maxID = rs.getInt(1);
					}
					System.out.println("最大値:" + maxID);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			//INSERT文を準備
			String sql = "insert into D_QUESTION ( Q_ID, Q_TITLE, Q_CONTENTS, Q_TAG01, Q_TAG02, Q_TAG03, Q_TAG04, Q_TAG05, USER_ID, Q_FILE, Q_DATE, DONE_TAG, COUNTER ) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURDATE(), 0, 0)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setInt(1,  maxID);
			pStmt.setString(2, param.getQ_title());
			pStmt.setString(3, param.getQ_contents());
			if (param.getQ_tag01() != null && !param.getQ_tag01().equals("")) {
				pStmt.setString(4, param.getQ_tag01());
			}
			else {
				pStmt.setString(4, null);
			}
			if (param.getQ_tag02() != null && !param.getQ_tag02().equals("")) {
				pStmt.setString(5, param.getQ_tag02());
			}
			else {
				pStmt.setString(5, null);
			}
			if (param.getQ_tag03() != null && !param.getQ_tag03().equals("")) {
				pStmt.setString(6, param.getQ_tag03());
			}
			else {
				pStmt.setString(6, null);
			}
			if (param.getQ_tag04() != null && !param.getQ_tag04().equals("")) {
				pStmt.setString(7, param.getQ_tag04());
			}
			else {
				pStmt.setString(7, null);
			}
			if (param.getQ_tag05() != null && !param.getQ_tag05().equals("")) {
				pStmt.setString(8, param.getQ_tag05());
			}
			else {
				pStmt.setString(8, null);
			}
			pStmt.setString(9, param.getUser_id());
			if (param.getQ_file() != null && !param.getQ_file().equals("")) {
				pStmt.setString(10, param.getQ_file());
			}
			else {
				pStmt.setString(10, null);
			}

			//SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				insertResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			//データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		//結果を返す
		return insertResult;
	}

	//質問詳細移動時のカウント回数+1
	//引数q_idで指定したレコードのカウンターの回数を最大値+1に更新し、成功したらtrueを返す
	public boolean updateCountup(int q_id) {

		Connection conn = null;
		boolean updateResult = false;

		try {

			//JDBCドライバ読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-4/QAsystem", "sa", "sa");

			//2021/06/14　ここからスタート
			//SQL文の準備
			String sql = "select COUNTER from D_QUESTION where = ?";

			//SQL文を完成させる
			pStmt.setInt(1, q_id);

			//SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//UPDATE文を準備
			String sql2 = "update D_QUESTIONS "
					+ "set COUNTER = ? "
					+ "where Q_ID = ?";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);

			//SQL文を完成させる
			pStmt.setInt(1,  maxID);
			pStmt.setInt(1,  maxID);

			//SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				updateResult = true;
			}
		}
	}
}

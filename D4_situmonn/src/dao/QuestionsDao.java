package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import model.Question;

public class QuestionsDao {

	//引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Question> select(Question param) {
		Connection conn = null;
		List<Question> cardList = new ArrayList<Question>();

		try {
			//JDBCドライバ読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-4/QAsystem", "sa", "sa");

			//SQL文を準備
			String sql = "select Q_ID, Q_TITLE, Q_CONTENTS, Q_TAG01, Q_TAG02, Q_TAG03, Q_TAG04, Q_TAG05, USER_ID, Q_FILE, Q_DATE, DONE_TAG, COUNTER "
					+ "from D_QUESTIONS "
					+ "where Q_ID = ? and USER_ID = ? "
					+ "order by Q_DATE desc";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			if (param.getQ_id() != 0) {
				pStmt.setInt(1, param.getQ_id());
			}
			else {
				pStmt.setInt(1, 0);
			}
			if (param.getUser_id() != null && !param.getUser_id().equals("")) {
				pStmt.setString(2, "%" + param.getUser_id() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}

			//SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//結果表をコレクションにコピーする
			while (rs.next()) {
				Question card = new Question(
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
						rs.getInt("COUNTER")
						);
				cardList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			//データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		//結果を返す
		return cardList;
	}

	//引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Question card) {
		Connection conn = null;
		boolean result = false;

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
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setInt(1,  maxID);
			if (card.getQ_title() != null && !card.getQ_title().equals("")) {
				pStmt.setString(2, card.getQ_title());
			}
			else {
				pStmt.setString(2, null);
			}
			if (card.getQ_contents() != null && !card.getQ_contents().equals("")) {
				pStmt.setString(3, card.getQ_contents());
			}
			else {
				pStmt.setString(3, null);
			}
			if (card.getQ_tag01() != null && !card.getQ_tag01().equals("")) {
				pStmt.setString(4, card.getQ_tag01());
			}
			else {
				pStmt.setString(4, null);
			}
			if (card.getQ_tag02() != null && !card.getQ_tag02().equals("")) {
				pStmt.setString(5, card.getQ_tag02());
			}
			else {
				pStmt.setString(5, null);
			}
			if (card.getQ_tag03() != null && !card.getQ_tag03().equals("")) {
				pStmt.setString(6, card.getQ_tag03());
			}
			else {
				pStmt.setString(6, null);
			}
			if (card.getQ_tag04() != null && !card.getQ_tag04().equals("")) {
				pStmt.setString(7, card.getQ_tag04());
			}
			else {
				pStmt.setString(7, null);
			}
			if (card.getQ_tag05() != null && !card.getQ_tag05().equals("")) {
				pStmt.setString(8, card.getQ_tag05());
			}
			else {
				pStmt.setString(8, null);
			}
			if (card.getUser_id() != null && !card.getUser_id().equals("")) {
				pStmt.setString(9, card.getUser_id());
			}
			else {
				pStmt.setString(9, null);
			}
			if (card.getQ_file() != null && !card.getQ_file().equals("")) {
				pStmt.setString(10, card.getQ_file());
			}
			else {
				pStmt.setString(10, null);
			}
			//2021/06/11 ここから
			if (card.getQ_date() != null && !card.getQ_date().equals("")) {
				pStmt.setDate(11, card.getQ_date());
			}
			else {
				pStmt.setString(11, null);
			}
			if (card.getQ_title() != null && !card.getQ_title().equals("")) {
				pStmt.setString(2, card.getQ_title());
			}
			else {
				pStmt.setString(2, null);
			}

		}
	}
}

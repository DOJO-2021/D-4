package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Question;
import model.QuestionList;

public class QuestionsListDao {

	//質問一覧検索時(解決済み)
	//引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Question> selectQListS(QuestionList param) {

		Connection conn = null;
		List<Question> QList = new ArrayList<Question>();

		try {
			//JDBCドライバ読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-4/QAsystem", "sa", "sa");

			//SQL文を準備
			String sql = "select D_QUESTIONS.Q_ID, D_QUESTIONS.Q_TITLE, substring(D_QUESTIONS.Q_CONTENTS, 1, 100) as Q_CONTENTS, "
					+ "D_QUESTIONS.Q_TAG01, D_QUESTIONS.Q_TAG02, D_QUESTIONS.Q_TAG03, D_QUESTIONS.Q_TAG04, D_QUESTIONS.Q_TAG05, "
					+ "D_QUESTIONS.USER_ID, D_QUESTIONS.Q_FILE, D_QUESTIONS.Q_DATE, D_QUESTIONS.DONE_TAG, D_QUESTIONS.COUNTER, M_USERS.USER_NAME "
					+ "from D_QUESTIONS "
					+ "inner join M_USERS "
					+ "on M_USERS.USER_ID = D_QUESTIONS.USER_ID "
					+ "where ( D_QUESTIONS.Q_TAG01 = ? or D_QUESTIONS.Q_TAG01 = ? or D_QUESTIONS.Q_TAG01 = ? or D_QUESTIONS.Q_TAG01 = ? or D_QUESTIONS.Q_TAG01 = ? or D_QUESTIONS.Q_TAG01 = ? or "
					+ "D_QUESTIONS.Q_TAG01 = ? or D_QUESTIONS.Q_TAG01 = ? or D_QUESTIONS.Q_TAG01 = ? or D_QUESTIONS.Q_TAG01 = ? or D_QUESTIONS.Q_TAG01 = ? or "
					+ "D_QUESTIONS.Q_TAG02 = ? or D_QUESTIONS.Q_TAG02 = ? or D_QUESTIONS.Q_TAG02 = ? or D_QUESTIONS.Q_TAG02 = ? or D_QUESTIONS.Q_TAG02 = ? or "
					+ "D_QUESTIONS.Q_TAG02 = ? or D_QUESTIONS.Q_TAG02 = ? or D_QUESTIONS.Q_TAG02 = ? or D_QUESTIONS.Q_TAG02 = ? or D_QUESTIONS.Q_TAG02 = ? or D_QUESTIONS.Q_TAG02 = ? or "
					+ "D_QUESTIONS.Q_TAG03 = ? or D_QUESTIONS.Q_TAG03 = ? or D_QUESTIONS.Q_TAG03 = ? or D_QUESTIONS.Q_TAG03 = ? or D_QUESTIONS.Q_TAG03 = ? or "
					+ "D_QUESTIONS.Q_TAG03 = ? or D_QUESTIONS.Q_TAG03 = ? or D_QUESTIONS.Q_TAG03 = ? or D_QUESTIONS.Q_TAG03 = ? or D_QUESTIONS.Q_TAG03 = ? or D_QUESTIONS.Q_TAG03 = ? or "
					+ "D_QUESTIONS.Q_TAG04 = ? or D_QUESTIONS.Q_TAG04 = ? or D_QUESTIONS.Q_TAG04 = ? or D_QUESTIONS.Q_TAG04 = ? or D_QUESTIONS.Q_TAG04 = ? or "
					+ "D_QUESTIONS.Q_TAG04 = ? or D_QUESTIONS.Q_TAG04 = ? or D_QUESTIONS.Q_TAG04 = ? or D_QUESTIONS.Q_TAG04 = ? or D_QUESTIONS.Q_TAG04 = ? or D_QUESTIONS.Q_TAG04 = ? or "
					+ "D_QUESTIONS.Q_TAG05 = ? or D_QUESTIONS.Q_TAG05 = ? or D_QUESTIONS.Q_TAG05 = ? or D_QUESTIONS.Q_TAG05 = ? or D_QUESTIONS.Q_TAG05 = ? or "
					+ "D_QUESTIONS.Q_TAG05 = ? or D_QUESTIONS.Q_TAG05 = ? or D_QUESTIONS.Q_TAG05 = ? or D_QUESTIONS.Q_TAG05 = ? or D_QUESTIONS.Q_TAG05 = ? or D_QUESTIONS.Q_TAG05 = ? or "
					+ "D_QUESTIONS.Q_CONTENTS like ? ) and D_QUESTIONS.DONE_TAG = 1 "
					+ "order by D_QUESTIONS.COUNTER desc, D_QUESTIONS.Q_ID";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			if (param.getQ_tag1() != null && !param.getQ_tag1().equals("")) {
				pStmt.setString(1, param.getQ_tag1());
				pStmt.setString(12, param.getQ_tag1());
				pStmt.setString(23, param.getQ_tag1());
				pStmt.setString(34, param.getQ_tag1());
				pStmt.setString(45, param.getQ_tag1());
			}
			else {
				pStmt.setString(1, null);
				pStmt.setString(12, null);
				pStmt.setString(23, null);
				pStmt.setString(34, null);
				pStmt.setString(45, null);
			}
			if (param.getQ_tag2() != null && !param.getQ_tag2().equals("")) {
				pStmt.setString(2, param.getQ_tag2());
				pStmt.setString(13, param.getQ_tag2());
				pStmt.setString(24, param.getQ_tag2());
				pStmt.setString(35, param.getQ_tag2());
				pStmt.setString(46, param.getQ_tag2());
			}
			else {
				pStmt.setString(2, null);
				pStmt.setString(13, null);
				pStmt.setString(24, null);
				pStmt.setString(35, null);
				pStmt.setString(46, null);
			}
			if (param.getQ_tag3() != null && !param.getQ_tag3().equals("")) {
				pStmt.setString(3, param.getQ_tag3());
				pStmt.setString(14, param.getQ_tag3());
				pStmt.setString(25, param.getQ_tag3());
				pStmt.setString(36, param.getQ_tag3());
				pStmt.setString(47, param.getQ_tag3());
			}
			else {
				pStmt.setString(3, null);
				pStmt.setString(14, null);
				pStmt.setString(25, null);
				pStmt.setString(36, null);
				pStmt.setString(47, null);
			}
			if (param.getQ_tag4() != null && !param.getQ_tag4().equals("")) {
				pStmt.setString(4, param.getQ_tag4());
				pStmt.setString(15, param.getQ_tag4());
				pStmt.setString(26, param.getQ_tag4());
				pStmt.setString(37, param.getQ_tag4());
				pStmt.setString(48, param.getQ_tag4());
			}
			else {
				pStmt.setString(4, null);
				pStmt.setString(15, null);
				pStmt.setString(26, null);
				pStmt.setString(37, null);
				pStmt.setString(48, null);
			}
			if (param.getQ_tag5() != null && !param.getQ_tag5().equals("")) {
				pStmt.setString(5, param.getQ_tag5());
				pStmt.setString(16, param.getQ_tag5());
				pStmt.setString(27, param.getQ_tag5());
				pStmt.setString(38, param.getQ_tag5());
				pStmt.setString(49, param.getQ_tag5());
			}
			else {
				pStmt.setString(5, null);
				pStmt.setString(16, null);
				pStmt.setString(27, null);
				pStmt.setString(38, null);
				pStmt.setString(49, null);
			}
			if (param.getQ_tag6() != null && !param.getQ_tag6().equals("")) {
				pStmt.setString(6, param.getQ_tag6());
				pStmt.setString(17, param.getQ_tag6());
				pStmt.setString(28, param.getQ_tag6());
				pStmt.setString(39, param.getQ_tag6());
				pStmt.setString(50, param.getQ_tag6());
			}
			else {
				pStmt.setString(6, null);
				pStmt.setString(17, null);
				pStmt.setString(28, null);
				pStmt.setString(39, null);
				pStmt.setString(50, null);
			}
			if (param.getQ_tag7() != null && !param.getQ_tag7().equals("")) {
				pStmt.setString(7, param.getQ_tag7());
				pStmt.setString(18, param.getQ_tag7());
				pStmt.setString(29, param.getQ_tag7());
				pStmt.setString(40, param.getQ_tag7());
				pStmt.setString(51, param.getQ_tag7());
			}
			else {
				pStmt.setString(7, null);
				pStmt.setString(18, null);
				pStmt.setString(29, null);
				pStmt.setString(40, null);
				pStmt.setString(51, null);
			}
			if (param.getQ_tag8() != null && !param.getQ_tag8().equals("")) {
				pStmt.setString(8, param.getQ_tag8());
				pStmt.setString(19, param.getQ_tag8());
				pStmt.setString(30, param.getQ_tag8());
				pStmt.setString(41, param.getQ_tag8());
				pStmt.setString(52, param.getQ_tag8());
			}
			else {
				pStmt.setString(8, null);
				pStmt.setString(19, null);
				pStmt.setString(30, null);
				pStmt.setString(41, null);
				pStmt.setString(52, null);
			}
			if (param.getQ_tag9() != null && !param.getQ_tag9().equals("")) {
				pStmt.setString(9, param.getQ_tag9());
				pStmt.setString(20, param.getQ_tag9());
				pStmt.setString(31, param.getQ_tag9());
				pStmt.setString(42, param.getQ_tag9());
				pStmt.setString(53, param.getQ_tag9());
			}
			else {
				pStmt.setString(9, null);
				pStmt.setString(20, null);
				pStmt.setString(31, null);
				pStmt.setString(42, null);
				pStmt.setString(53, null);
			}
			if (param.getQ_tag10() != null && !param.getQ_tag10().equals("")) {
				pStmt.setString(10, param.getQ_tag10());
				pStmt.setString(21, param.getQ_tag10());
				pStmt.setString(32, param.getQ_tag10());
				pStmt.setString(43, param.getQ_tag10());
				pStmt.setString(54, param.getQ_tag10());
			}
			else {
				pStmt.setString(10, null);
				pStmt.setString(21, null);
				pStmt.setString(32, null);
				pStmt.setString(43, null);
				pStmt.setString(54, null);
			}
			if (param.getQ_tag11() != null && !param.getQ_tag11().equals("")) {
				pStmt.setString(11, param.getQ_tag11());
				pStmt.setString(22, param.getQ_tag11());
				pStmt.setString(33, param.getQ_tag11());
				pStmt.setString(44, param.getQ_tag11());
				pStmt.setString(55, param.getQ_tag11());
			}
			else {
				pStmt.setString(11, null);
				pStmt.setString(22, null);
				pStmt.setString(33, null);
				pStmt.setString(44, null);
				pStmt.setString(55, null);
			}
			if (param.getQ_contents() != null && !param.getQ_contents().equals("")) {
				pStmt.setString(56, "%" + param.getQ_contents() + "%");
			}
			else {
				pStmt.setString(56, null);
			}

			//SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//結果表をコレクションにコピーする
			while (rs.next()) {
				Question MyQList = new Question(
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
				QList.add(MyQList);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			QList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			QList = null;
		}
		finally {
			//データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					QList = null;
				}
			}
		}

		//結果を返す
		return QList;
	}

	//質問一覧検索時(未解決)
	//引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Question> selectQListU(QuestionList param) {

		Connection conn = null;
		List<Question> QList = new ArrayList<Question>();

		try {
			//JDBCドライバ読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-4/QAsystem", "sa", "sa");

			//SQL文を準備
			String sql = "select D_QUESTIONS.Q_ID, D_QUESTIONS.Q_TITLE, substring(D_QUESTIONS.Q_CONTENTS, 1, 100) as Q_CONTENTS, "
					+ "D_QUESTIONS.Q_TAG01, D_QUESTIONS.Q_TAG02, D_QUESTIONS.Q_TAG03, D_QUESTIONS.Q_TAG04, D_QUESTIONS.Q_TAG05, "
					+ "D_QUESTIONS.USER_ID, D_QUESTIONS.Q_FILE, D_QUESTIONS.Q_DATE, D_QUESTIONS.DONE_TAG, D_QUESTIONS.COUNTER, M_USERS.USER_NAME "
					+ "from D_QUESTIONS "
					+ "inner join M_USERS "
					+ "on M_USERS.USER_ID = D_QUESTIONS.USER_ID "
					+ "where ( D_QUESTIONS.Q_TAG01 = ? or D_QUESTIONS.Q_TAG01 = ? or D_QUESTIONS.Q_TAG01 = ? or D_QUESTIONS.Q_TAG01 = ? or D_QUESTIONS.Q_TAG01 = ? or D_QUESTIONS.Q_TAG01 = ? or "
					+ "D_QUESTIONS.Q_TAG01 = ? or D_QUESTIONS.Q_TAG01 = ? or D_QUESTIONS.Q_TAG01 = ? or D_QUESTIONS.Q_TAG01 = ? or D_QUESTIONS.Q_TAG01 = ? or "
					+ "D_QUESTIONS.Q_TAG02 = ? or D_QUESTIONS.Q_TAG02 = ? or D_QUESTIONS.Q_TAG02 = ? or D_QUESTIONS.Q_TAG02 = ? or D_QUESTIONS.Q_TAG02 = ? or "
					+ "D_QUESTIONS.Q_TAG02 = ? or D_QUESTIONS.Q_TAG02 = ? or D_QUESTIONS.Q_TAG02 = ? or D_QUESTIONS.Q_TAG02 = ? or D_QUESTIONS.Q_TAG02 = ? or D_QUESTIONS.Q_TAG02 = ? or "
					+ "D_QUESTIONS.Q_TAG03 = ? or D_QUESTIONS.Q_TAG03 = ? or D_QUESTIONS.Q_TAG03 = ? or D_QUESTIONS.Q_TAG03 = ? or D_QUESTIONS.Q_TAG03 = ? or "
					+ "D_QUESTIONS.Q_TAG03 = ? or D_QUESTIONS.Q_TAG03 = ? or D_QUESTIONS.Q_TAG03 = ? or D_QUESTIONS.Q_TAG03 = ? or D_QUESTIONS.Q_TAG03 = ? or D_QUESTIONS.Q_TAG03 = ? or "
					+ "D_QUESTIONS.Q_TAG04 = ? or D_QUESTIONS.Q_TAG04 = ? or D_QUESTIONS.Q_TAG04 = ? or D_QUESTIONS.Q_TAG04 = ? or D_QUESTIONS.Q_TAG04 = ? or "
					+ "D_QUESTIONS.Q_TAG04 = ? or D_QUESTIONS.Q_TAG04 = ? or D_QUESTIONS.Q_TAG04 = ? or D_QUESTIONS.Q_TAG04 = ? or D_QUESTIONS.Q_TAG04 = ? or D_QUESTIONS.Q_TAG04 = ? or "
					+ "D_QUESTIONS.Q_TAG05 = ? or D_QUESTIONS.Q_TAG05 = ? or D_QUESTIONS.Q_TAG05 = ? or D_QUESTIONS.Q_TAG05 = ? or D_QUESTIONS.Q_TAG05 = ? or "
					+ "D_QUESTIONS.Q_TAG05 = ? or D_QUESTIONS.Q_TAG05 = ? or D_QUESTIONS.Q_TAG05 = ? or D_QUESTIONS.Q_TAG05 = ? or D_QUESTIONS.Q_TAG05 = ? or D_QUESTIONS.Q_TAG05 = ? or "
					+ "D_QUESTIONS.Q_CONTENTS like ? ) and D_QUESTIONS.DONE_TAG = 0 "
					+ "order by D_QUESTIONS.Q_DATE, D_QUESTIONS.Q_ID";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			if (param.getQ_tag1() != null && !param.getQ_tag1().equals("")) {
				pStmt.setString(1, param.getQ_tag1());
				pStmt.setString(12, param.getQ_tag1());
				pStmt.setString(23, param.getQ_tag1());
				pStmt.setString(34, param.getQ_tag1());
				pStmt.setString(45, param.getQ_tag1());
			}
			else {
				pStmt.setString(1, null);
				pStmt.setString(12, null);
				pStmt.setString(23, null);
				pStmt.setString(34, null);
				pStmt.setString(45, null);
			}
			if (param.getQ_tag2() != null && !param.getQ_tag2().equals("")) {
				pStmt.setString(2, param.getQ_tag2());
				pStmt.setString(13, param.getQ_tag2());
				pStmt.setString(24, param.getQ_tag2());
				pStmt.setString(35, param.getQ_tag2());
				pStmt.setString(46, param.getQ_tag2());
			}
			else {
				pStmt.setString(2, null);
				pStmt.setString(13, null);
				pStmt.setString(24, null);
				pStmt.setString(35, null);
				pStmt.setString(46, null);
			}
			if (param.getQ_tag3() != null && !param.getQ_tag3().equals("")) {
				pStmt.setString(3, param.getQ_tag3());
				pStmt.setString(14, param.getQ_tag3());
				pStmt.setString(25, param.getQ_tag3());
				pStmt.setString(36, param.getQ_tag3());
				pStmt.setString(47, param.getQ_tag3());
			}
			else {
				pStmt.setString(3, null);
				pStmt.setString(14, null);
				pStmt.setString(25, null);
				pStmt.setString(36, null);
				pStmt.setString(47, null);
			}
			if (param.getQ_tag4() != null && !param.getQ_tag4().equals("")) {
				pStmt.setString(4, param.getQ_tag4());
				pStmt.setString(15, param.getQ_tag4());
				pStmt.setString(26, param.getQ_tag4());
				pStmt.setString(37, param.getQ_tag4());
				pStmt.setString(48, param.getQ_tag4());
			}
			else {
				pStmt.setString(4, null);
				pStmt.setString(15, null);
				pStmt.setString(26, null);
				pStmt.setString(37, null);
				pStmt.setString(48, null);
			}
			if (param.getQ_tag5() != null && !param.getQ_tag5().equals("")) {
				pStmt.setString(5, param.getQ_tag5());
				pStmt.setString(16, param.getQ_tag5());
				pStmt.setString(27, param.getQ_tag5());
				pStmt.setString(38, param.getQ_tag5());
				pStmt.setString(49, param.getQ_tag5());
			}
			else {
				pStmt.setString(5, null);
				pStmt.setString(16, null);
				pStmt.setString(27, null);
				pStmt.setString(38, null);
				pStmt.setString(49, null);
			}
			if (param.getQ_tag6() != null && !param.getQ_tag6().equals("")) {
				pStmt.setString(6, param.getQ_tag6());
				pStmt.setString(17, param.getQ_tag6());
				pStmt.setString(28, param.getQ_tag6());
				pStmt.setString(39, param.getQ_tag6());
				pStmt.setString(50, param.getQ_tag6());
			}
			else {
				pStmt.setString(6, null);
				pStmt.setString(17, null);
				pStmt.setString(28, null);
				pStmt.setString(39, null);
				pStmt.setString(50, null);
			}
			if (param.getQ_tag7() != null && !param.getQ_tag7().equals("")) {
				pStmt.setString(7, param.getQ_tag7());
				pStmt.setString(18, param.getQ_tag7());
				pStmt.setString(29, param.getQ_tag7());
				pStmt.setString(40, param.getQ_tag7());
				pStmt.setString(51, param.getQ_tag7());
			}
			else {
				pStmt.setString(7, null);
				pStmt.setString(18, null);
				pStmt.setString(29, null);
				pStmt.setString(40, null);
				pStmt.setString(51, null);
			}
			if (param.getQ_tag8() != null && !param.getQ_tag8().equals("")) {
				pStmt.setString(8, param.getQ_tag8());
				pStmt.setString(19, param.getQ_tag8());
				pStmt.setString(30, param.getQ_tag8());
				pStmt.setString(41, param.getQ_tag8());
				pStmt.setString(52, param.getQ_tag8());
			}
			else {
				pStmt.setString(8, null);
				pStmt.setString(19, null);
				pStmt.setString(30, null);
				pStmt.setString(41, null);
				pStmt.setString(52, null);
			}
			if (param.getQ_tag9() != null && !param.getQ_tag9().equals("")) {
				pStmt.setString(9, param.getQ_tag9());
				pStmt.setString(20, param.getQ_tag9());
				pStmt.setString(31, param.getQ_tag9());
				pStmt.setString(42, param.getQ_tag9());
				pStmt.setString(53, param.getQ_tag9());
			}
			else {
				pStmt.setString(9, null);
				pStmt.setString(20, null);
				pStmt.setString(31, null);
				pStmt.setString(42, null);
				pStmt.setString(53, null);
			}
			if (param.getQ_tag10() != null && !param.getQ_tag10().equals("")) {
				pStmt.setString(10, param.getQ_tag10());
				pStmt.setString(21, param.getQ_tag10());
				pStmt.setString(32, param.getQ_tag10());
				pStmt.setString(43, param.getQ_tag10());
				pStmt.setString(54, param.getQ_tag10());
			}
			else {
				pStmt.setString(10, null);
				pStmt.setString(21, null);
				pStmt.setString(32, null);
				pStmt.setString(43, null);
				pStmt.setString(54, null);
			}
			if (param.getQ_tag11() != null && !param.getQ_tag11().equals("")) {
				pStmt.setString(11, param.getQ_tag11());
				pStmt.setString(22, param.getQ_tag11());
				pStmt.setString(33, param.getQ_tag11());
				pStmt.setString(44, param.getQ_tag11());
				pStmt.setString(55, param.getQ_tag11());
			}
			else {
				pStmt.setString(11, null);
				pStmt.setString(22, null);
				pStmt.setString(33, null);
				pStmt.setString(44, null);
				pStmt.setString(55, null);
			}
			if (param.getQ_contents() != null && !param.getQ_contents().equals("")) {
				pStmt.setString(56, "%" + param.getQ_contents() + "%");
			}
			else {
				pStmt.setString(56, null);
			}

			//SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//結果表をコレクションにコピーする
			while (rs.next()) {
				Question MyQList = new Question(
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
				QList.add(MyQList);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			QList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			QList = null;
		}
		finally {
			//データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					QList = null;
				}
			}
		}

		//結果を返す
		return QList;
	}
}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UsersDao {

	//ログイン用
	//引数user_id,passwordで検索し、ログインできるならtrueを返す
	public boolean isLoginOK(String user_id, String password) {
		Connection conn = null;
		boolean loginResult =false;

		try {
			//JDBCドライバ読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-4/QAsystem", "sa", "sa");

			//SELECT文の準備
			String sql = "select count(*) "
					+ "from M_USERS "
					+ "where USER_ID = ? and PASSWORD = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user_id);
			pStmt.setString(2, password);

			//SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//ユーザIDとパスワードが一致するユーザがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			//データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		//結果を返す
		return loginResult;
	}

	//ユーザ登録前のチェック用
	//引数user_idで検索し、既存のIDとかぶりがない場合trueを返す
	public boolean insertcheck(String user_id) {
		Connection conn = null;
		boolean CheckResult = false;

		try {

			//JDBCドライバ読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-4/QAsystem", "sa", "sa");

			//SELECT文の準備
			String sql = "select count(*) "
					+ "from M_USERS "
					+ "where USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user_id);

			//SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//ユーザIDが一致するユーザがいるかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 0) {
				CheckResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			CheckResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			CheckResult = false;
		}
		finally {
			//データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					CheckResult = false;
				}
			}
		}

		//結果を返す
		return CheckResult;
	}

	//ユーザ登録用
	//引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(User card) {
		Connection conn = null;
		boolean insertResult = false;

		try {

			//INSERT文を準備
			String sql = "insert into M_USERS ( USER_ID, PASSWORD, USER_NAME, COMPANY, USER_CATEGORY ) "
					+ "values ( ?, ?, ?, ?, ?)";
			//JDBCドライバ読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-4/QAsystem", "sa", "sa");

			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setString(1, card.getUser_id());
			pStmt.setString(2, card.getPassword());
			pStmt.setString(3, card.getUser_name());
			if (card.getCompany() != null && !card.getCompany().equals("")) {
				pStmt.setString(4, card.getCompany());
			}
			else {
				pStmt.setString(4, null);
			}
			pStmt.setString(5, card.getUser_category());

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

	//プロフィール表示 & プロフィール編集表示用
	//引数user_idで検索項目を指定し、検索結果のリストを返す
	public List<User> select(String user_id) {
		Connection conn = null;
		List<User> cardList = new ArrayList<User>();

		try {

			//JDBCドライバ読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-4/QAsystem", "sa", "sa");

			//SELECT文を準備
			String sql = "select USER_ID, PASSWORD, USER_NAME, COMPANY, USER_CATEGORY from M_USERS where USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setString(1, user_id);

			//SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//結果表をコレクションにコピーする
			while (rs.next()) {
				User card = new User(
						rs.getString("USER_ID"),
						rs.getString("PASSWORD"),
						rs.getString("USER_NAME"),
						rs.getString("COMPANY"),
						rs.getString("USER_CATEGORY")
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

	//プロフィール編集用
	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(User card) {
		Connection conn = null;
		boolean updateResult = false;

		try {

			//JDBCドライバ読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-4/QAsystem", "sa", "sa");

			//UPDATE文を準備
			String sql = "update M_USERS "
					+ "set PASSWORD = ?, USER_NAME = ?, COMPANY = ? "
					+ "where USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setString(1, card.getPassword());
			pStmt.setString(2, card.getUser_name());
			if (card.getCompany() != null && !card.getCompany().equals("")) {
				pStmt.setString(3, card.getCompany());
			}
			else {
				pStmt.setString(3, null);
			}
			pStmt.setString(4, card.getUser_id());

			//SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				updateResult = true;
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
		return updateResult;
	}
}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDao {

	//ログインできるならtrueを返す
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
					+ "from IDPW "
					+ "where ID = ? and PW = ?";
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
}

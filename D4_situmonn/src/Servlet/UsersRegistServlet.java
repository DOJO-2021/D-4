package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;

import dao.UsersDao;

/**
 * Servlet implementation class UsersRegistServlet
 */
@WebServlet("/UsersRegistServlet")
public class UsersRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
 /**  super classはいらない
     public UsersRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    } **/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/D4_situmonn/LoginServlet");
			return;
		}

		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usersregist.jsp");
		dispatcher.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/D4_situmonn/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("id_input");
		String password = request.getParameter("password_input");
		String user_name = request.getParameter("name_input");
		String company = request.getParameter("company_input");
		String user_category = request.getParameter("user_category");

		// リクエストパラメータのチェックはいる？→jspで記述してあるので不要

		// IDが重複している場合アラートを表示
		class main {
			public main(String[] args) {
		System.out.println("このIDは既に使用されています。変更してください。");
		 }
		}

		// 登録処理を行う
		UsersDao UDao = new UsersDao();
		if (UDao.insert(new User(user_id, password, user_name, company, user_category))) {	// 登録成功
			request.setAttribute("result",
			new Result("登録成功！", "レコードを登録しました。", "/D4_situmonn/TopServlet"));
		} //resultのbeansがないので赤線が出る。作成するか相談する。
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("登録失敗！", "レコードを登録できませんでした。", "/D4_situmonn/LoginServlet"));
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usersresult.jsp");
		dispatcher.forward(request, response);
	}

}

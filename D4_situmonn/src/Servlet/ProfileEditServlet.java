package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDao;
import model.Result;
import model.User;

/**
 * Servlet implementation class ProfileEditServlet
 */
@WebServlet("/ProfileEditServlet")
public class ProfileEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


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

		// プロフィール編集ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profileedit.jsp");//パス名を変更
		dispatcher.forward(request, response);
	}
		/*
		// user_idを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = (String) session.getAttribute("id");

		//プロフィールの検索処理
		UsersDao UDao = new UsersDao();
		List<User> cardList = UDao.select(user_id);

		//リクエストスコープに格納する
		request.setAttribute("cardList", cardList);
		*/


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
		String user_id = (String) session.getAttribute("id");
		String password = request.getParameter("password_input");
		String user_name  = request.getParameter("name_input");
		String company = request.getParameter("company_input");


		//更新処理
		UsersDao UDao = new UsersDao();
		if (UDao.update(new User(user_id, password, user_name, company, ""))){
			request.setAttribute("result", new Result("プロフィールを更新しました。"));
		}
		else {
			request.setAttribute("result", new Result("プロフィールの更新に失敗しました。"));
		}
	}
}

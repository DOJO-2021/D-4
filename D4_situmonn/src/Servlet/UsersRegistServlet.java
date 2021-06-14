package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String id_input = request.getParameter("id_input");
		String password_input = request.getParameter("password_input");
		String name_input = request.getParameter("name_input");
		String company_input = request.getParameter("company_input");
		String user_category = request.getParameter("user_category");

		// リクエストパラメータのチェックはいる？→jspで記述してあるので不要

		// 登録処理を行う
		UsersDAO UDao = new UsersDAO();
		if (UDao.insert(new Users(0, id_input, password_input, name_input, company_input, user_category))) {	// 登録成功
			request.setAttribute("result",
			new Result("登録成功！", "レコードを登録しました。", "/D4_situmonn/TopServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("登録失敗！", "レコードを登録できませんでした。", "/simpleBC/MenuServlet"));
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}


		doGet(request, response);
	}

}

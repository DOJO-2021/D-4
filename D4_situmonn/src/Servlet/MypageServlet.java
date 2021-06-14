package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuestionsDao;
import dao.UsersDao;
import model.User;

/**
 * Servlet implementation class MyapageServlet
 */
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/D-4situmonn/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String company = request.getParameter("company");
		String user_category = request.getParameter("user_category");

		// ログインしているユーザーの検索処理を行う
		UsersDao UDao = new UsersDao();
		List<User> cardList = UDao.select(new User(user_id));

	    // 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		// マイページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
		}

        // ログインしているユーザーの質問の検索処理を行う
	    QuestionsDao QDao = new QuestionsDao();
	    List<User> cardList = QDao.select(new User(user_id));

        // 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		// マイページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
		}
}

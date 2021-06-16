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
import model.Question;
import model.User;

/**
 * Servlet implementation class MyapageServlet
 */
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {
			    response.sendRedirect("/D4_situmonn/LoginServlet");
			    return;
		    }

		// ログインしているユーザーの検索処理を行う
		UsersDao UDao = new UsersDao();
		String user_id = (String) session.getAttribute("id");
		System.out.println("ユーザID：" + user_id);
		List<User> cardList = UDao.select(user_id);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);




	    //リスエスとスコープに保存された検索結果のリストを取得【保留：user_idは二回使えない→変えてもよいのか？2021/06/15】
		QuestionsDao QDao = new QuestionsDao();
		//String id = (String) session.getAttribute("id");
		System.out.println("ユーザID：" + user_id);
		List<Question> QList = QDao.selectMyQList(user_id);

		// 検索結果をリクエストスコープに格納する
	 	request.setAttribute("QList", QList);

	    // マイページにフォワードする
	 	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
	 	dispatcher.forward(request, response);
	 	}

	}


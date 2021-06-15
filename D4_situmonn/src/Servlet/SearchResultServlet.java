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
import model.Question;

/**
 * Servlet implementation class SearchResultServlet
 */
@WebServlet("/SearchResultServlet")
public class SearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// もしもログインしていなかったらログインサーブレットにリダイレクトする
	HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
		    response.sendRedirect("/D-4situmonn/LoginServlet");
		    return;
	    }

		//リスエスとスコープに保存された検索結果のリストを取得　【リストの取得について保留2021/06/15】
		QuestionsDao QDao = new QuestionsDao();
		String user_id = (String) session.getAttribute("id");
		System.out.println("ユーザID：" + user_id);
	    List<Question> QList = QDao.selectMyQList(user_id);

        //検索結果を日付の古い順に表示するやり方【保留　2021/06/15】


	   // 検索結果をリクエストスコープに格納する
	 		request.setAttribute("QList", QList);

	    // 検索結果ページにフォワードする
	 		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/seachreslut.jsp");
	 		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/D-4situmonn/LoginServlet");
			return;
		}

		//
		request.setCharacterEncoding("UTF-8");
		int q_id = Integer.parseInt(request.getParameter("Q_ID"));

		QuestionsDao qDao = new QuestionsDao();
		List<Question> QEdit = qDao.selectQDetail(q_id);

		request.setAttribute("QEdit", QEdit);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/searchresult.jsp");
		dispatcher.forward(request, response);
	}




}

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

import dao.AnswersDao;
import dao.QuestionsDao;
import model.Answer;
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
		    response.sendRedirect("./LoginServlet");
		    return;
	    }

	    // 検索結果ページにフォワードする
	 	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/seachreslut.jsp");
	 	dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("./LoginServlet");
			return;
		}

		//引数q_idの取得
		request.setCharacterEncoding("UTF-8");
		int q_id = Integer.parseInt(request.getParameter("Q_ID"));

		//質問詳細情報取得
		QuestionsDao qDao = new QuestionsDao();
		List<Question> QEdit = qDao.selectQDetail(q_id);

		//上記をリクエストスコープに格納
		request.setAttribute("QEdit", QEdit);

		//回答情報取得
		AnswersDao aDao = new AnswersDao();
		List<Answer> AnswerList = aDao.List(q_id);

		//上記をリクエストスコープに格納
		request.setAttribute("AnswerList", AnswerList);

		//質問詳細ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/answersdetail.jsp");
		dispatcher.forward(request, response);
	}

}

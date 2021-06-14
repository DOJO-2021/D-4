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

import model.Question;

/**
 * Servlet implementation class TopServlet
 */
@WebServlet("/TopServlet")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// トップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");//パス名を変更
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
		//【保留】質問タグのリクエストパラメータの取得方法
		String q_tag1 = request.getParameter("question_tag1");
		String q_tag2 = request.getParameter("question_tag2");
		String q_tag3= request.getParameter("question_tag3");
		String q_tag4= request.getParameter("question_tag4");
		String q_tag5 = request.getParameter("question_tag5");
		String q_tag6 = request.getParameter("question_tag6");
		String q_tag7 = request.getParameter("question_tag7");
		String q_tag8 = request.getParameter("question_tag8");
		String q_tag9 = request.getParameter("question_tag9");
		String q_tag10 = request.getParameter("question_tag10");
		String q_tag11 = request.getParameter("question_tag11");

		String keyword = request.getParameter("keyword");

		//【保留】解決未解決ラベルはString型に、値は0か1
		String solution_label = request.getParameter("solution_label");


		// 【保留】検索処理を行う 検索に関係ない場所は "" かIDは0にする
		QuestionsDao qDao = new qDao();
		List<Question> answerList = qDao.select(new Question()));  //クラス名Questionでいいのか分からない+newしたときの()の中身


		// 検索結果をリクエストスコープに格納する
		request.setAttribute("answerList", answerList);


		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/searchresult.jsp");
		dispatcher.forward(request, response);
	}


}

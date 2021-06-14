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



		QuestionsDao qDao = new QuestionsDao();

		//解決か未解決かで呼び出すメソッド異なる？　解決→selectQListS、未解決→
		// 【保留】！new Questionの引数入れる　検索処理を行う 検索に関係ない場所は "" かIDは0にする
		if (solution_label == "1") {  //解決済みの時の検索処理とリクエストスコープへの格納
		  List<Question> QList = qDao.selectQListS(new Question());
		  request.setAttribute("QList", QList);
		}
		else if(solution_label == "0"){  //未解決の時の検索処理とリクエストスコープへの格納

		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/searchresult.jsp");
		dispatcher.forward(request, response);
	}


}

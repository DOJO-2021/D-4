package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AnswersDao;
import model.Answer;
import model.Result;

/**
 * Servlet implementation class AnswersDetailServlet
 */
@WebServlet("/AnswersDetailServlet")
public class AnswersDetailServlet extends HttpServlet {
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

		// 質問詳細ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/answersdetail.jsp");//パス名を変更
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
		// リクエストパラメータを取得する ans_idやq_idとかの取得方法
		//ユーザーがフォームで入力したフィールド以外はどう取得する？

		request.setCharacterEncoding("UTF-8");
		String ANS_CONTENTS = request.getParameter("newanswer");


		//登録処理を行う
		AnswersDao ansDao = new AnswersDao();
		if (ansDao.insert(new Answer(ANS_ID,Q_ID,ANS_CONTENTS,USER_ID,ANS_DATE))){  //登録成功
			request.setAttribute("result",
			new Result("回答を送信しました。"));
		}
		else {	// 登録失敗
			request.setAttribute("result",new Result("回答を送信できませんでした。"));
		}

		// 同じページ（質問詳細ページ）にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/answersdetail.jsp");
		dispatcher.forward(request, response);
	}
}


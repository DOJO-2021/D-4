package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
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
		//質問の表示
		//検索処理を行う q_idをどう取得するのか分からない
		QuestionsDao qDao = new QuestionsDao();
		List<Question> QEdit = qDao.selectQDetail(q_id);

		//リクエストスコープに格納する
		request.setAttribute("QEdit", QEdit);

		/*ここから回答一覧の表示*/

		//リクエストパラメータを取得
		String ANS_CONTENTS = request.getParameter("newanswer");


		//検索処理
		dao.AnswersDao ansDao = new AnswersDao();
		List<Answer> AnswerList = ansDao.List(new Answer(ANS_CONTENTS, ""));


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
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String ANS_CONTENTS = request.getParameter("newanswer");
		}

		//登録処理を行う
		AnswersDao ansDao = new AnswersDao();
		if (ansDao.insert(new Answer("", "", ANS_CONTENTS,"" ,""))){  //登録成功
			request.setAttribute("result",
			new Result("回答を送信しました。"));
		}
		else {	// 登録失敗
			request.setAttribute("result",new Result("回答を送信できませんでした。"));
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}
}


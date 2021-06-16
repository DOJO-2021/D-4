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
import model.LoginUser;
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
			response.sendRedirect("./LoginServlet");
			return;
		}

		// 質問詳細ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/answersdetail.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("./LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		//ans_idは最大値を取るため記述不要
		//q_idはjspのQ_ID(hidden)から取得する
		int Q_ID = Integer.parseInt(request.getParameter("Q_ID"));
		String ANS_CONTENTS = request.getParameter("newanswer");
		LoginUser USER_ID = (LoginUser) session.getAttribute("id");
		//回答日時については回答した日付をSQL側で入れるため記述不要

		//登録処理を行う
		AnswersDao ansDao = new AnswersDao();
		if (ansDao.insert(new Answer(0, Q_ID, ANS_CONTENTS, USER_ID.getId(), null))){  //登録成功
			request.setAttribute("result",new Result("回答を送信しました。"));
		}
		else {	// 登録失敗
			request.setAttribute("result",new Result("回答を送信できませんでした。"));
		}

		// 同じページ（質問詳細ページ）にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/answersdetail.jsp");
		dispatcher.forward(request, response);
	}
}


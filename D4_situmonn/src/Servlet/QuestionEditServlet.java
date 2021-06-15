package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuestionsDao;
import model.Question;
import model.Result;

/**
 * Servlet implementation class QuestionEditServlet
 */
@WebServlet("/QuestionEditServlet")
public class QuestionEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/D4_situmonn/LoginServlet");
			return;
		}

		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/questionpost.jsp");
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
	    String q_title = request.getParameter("question_title");
	    String q_contents = request.getParameter("question_contents");
	    String q_tag01 = request.getParameter("question_tag1");
	    String q_tag02 = request.getParameter("question_tag2");
	    String q_tag03 = request.getParameter("question_tag3");
	    String q_tag04 = request.getParameter("question_tag4");
	    String q_tag05 = request.getParameter("question_tag5");
	    }

	    // 質問タグを最低1つ、最大5つ選択する

	    // 添付ファイル


	    // 解決チェックボックス

        // 登録更新処理 question dao
        QuestionsDao QDao = new QuestionsDao();
        if (QDao.update(new Question(q_id, q_title, q_contents, q_tag01, q_tag02, q_tag03, q_tag04, q_tag05,
    		user_id, q_file, q_date, 0, counter, user_name)))  {
		// QuestionのIDは保留
    	// Questionのuser_idは保留。どうやって情報を取得するのか？
    	// Stringに変えるのか？
    	request.setAttribute("result",
		new Result("質問を更新しました。"));
    	}
     	else {
		request.setAttribute("result",
		new Result("質問を更新できませんでした。"));
    	}

        // キャンセルをクリック



	    // マイページにフォワードする
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
	    dispatcher.forward(request, response);
              }
        }

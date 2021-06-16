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
import model.LoginUser;
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
		// 質問編集ページにフォワードする処理
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/questionedit.jsp");//パス名を変更
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
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
	    LoginUser user = (LoginUser) session.getAttribute("id");

	    List<Question> QList =(List<Question>)request.getAttribute("QList");
	    int q_id=Question.getQ_id();


	    // 質問タグを最低1つ、最大5つ選択する

	    // 添付ファイル


	    // 解決チェックボックス
        String done_tag = request.getParameter("solution_button");

        // 登録更新処理 question dao
        QuestionsDao QDao = new QuestionsDao();
        if (QDao.updateQEdit(new Question(q_id, q_title, q_contents,  q_tag01, q_tag02, q_tag03,
    		q_tag04, q_tag05, user_id, q_file, q_date, done_tag, counter,
    		user_name)))  {
		// Questionのq_id, user_id, q_file, q_date, counter, user_nameは保留。
        //どうやって情報を取得するのか？

    	request.setAttribute("result",
		new Result("質問を更新しました。"));
    	}
     	else {
		request.setAttribute("result",
		new Result("質問を更新できませんでした。"));
    	}

        // キャンセルをクリック→jspで記述したのでいらない。

	    // マイページにフォワードする
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
	    dispatcher.forward(request, response);
              }
        }

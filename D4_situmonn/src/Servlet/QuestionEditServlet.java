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

		//リスエスとスコープに保存された検索結果のリストを取得【保留：user_idは二回使えない→変えてもよいのか？2021/06/15】
		QuestionsDao QDao = new QuestionsDao();
		LoginUser user = (LoginUser) session.getAttribute("id");
		System.out.println("ユーザID：" + user.getId());
		List<Question> QList = QDao.selectMyQList(user.getId());

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("QList", QList);

		// 質問編集ページにフォワードする処理
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/questionedit.jsp");//パス名を変更
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
    	int q_id=Integer.parseInt (request.getParameter("q_id"));
	    String q_title = request.getParameter("question_title");
	    String q_contents = request.getParameter("question_contents");
	    String q_tag01 = request.getParameter("question_tag1");
	    String q_tag02 = request.getParameter("question_tag2");
	    String q_tag03 = request.getParameter("question_tag3");
	    String q_tag04 = request.getParameter("question_tag4");
	    String q_tag05 = request.getParameter("question_tag5");
	    LoginUser user = (LoginUser) session.getAttribute("id");
	    String user_id=user.getId();
	    String q_file=request.getParameter("q_file");
        int done_tag = Integer.parseInt(request.getParameter("solution_button"));

        // 登録更新処理 question dao
        QuestionsDao QDao = new QuestionsDao();
        if (QDao.updateQEdit(new Question(q_id, q_title, q_contents,  q_tag01, q_tag02, q_tag03,
    		q_tag04, q_tag05, user_id, q_file, null, done_tag, 0,"")))  {
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

	    // マイページにリダイレクトする
        response.sendRedirect("/D4_situmonn/MypageServlet");
		return;
    }
}

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
import dao.TemplateDao;
import model.LoginUser;
import model.Question;
import model.Result;
import model.Template;



/**
 * Servlet implementation class QuestionsPostServlet
 */
@WebServlet("/QuestionsPostServlet")
public class QuestionsPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private ServletRequest request;

    /**
     * @see HttpServlet#HttpServlet()
     */
    /** public QuestionsPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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

		TemplateDao tDao = new TemplateDao();
		List<Template> Template = tDao.Template();
		request.setAttribute("Template", Template);

		LoginUser user = (LoginUser) session.getAttribute("id");

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("id", user.getId());
		// 登録ページにフォワーする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/questionpost.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // リクエストパラメータを取得する?
    	request.setCharacterEncoding("UTF-8");
	    String q_title = request.getParameter("question_title");
	    String q_contents = request.getParameter("question_contents");
	    String q_tag01 = request.getParameter("question_tag1");
	    String q_tag02 = request.getParameter("question_tag2");
	    String q_tag03 = request.getParameter("question_tag3");
	    String q_tag04 = request.getParameter("question_tag4");
	    String q_tag05 = request.getParameter("question_tag5");
	    String user_id = request.getParameter("user_id");
	    String q_file = request.getParameter("file_select");


		// 質問タグを最低1つ、最大5つ選択する

		// 添付ファイル

	    // 質問タグが1つも入力されていなかった場合、アラートを表示し、データ送信されずに元の入力画面に戻る。

	    //登録処理 question dao
	    QuestionsDao QDao = new QuestionsDao();
	    if (QDao.insertQRecord(new Question(q_title, q_contents, q_tag01, q_tag02, q_tag03, q_tag04, q_tag05,
	    		user_id, q_file)))  {
			// QuestionのIDは保留
	    	// Questionのuser_idは保留。どうやって情報を取得するのか？
	    	// Stringに変えるのか？
	    	request.setAttribute("result",
			new Result("質問登録成功！", "/WEB-INF/jsp/top.jsp"));
	    	}
	     	else {
			request.setAttribute("result",
			new Result("質問登録失敗！", "/WEB-INF/jsp/top.jsp"));
	    	}

	    // テンプレ挿入機能はどのようにしたらよいか？
		// トップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
		dispatcher.forward(request, response);
	}

}

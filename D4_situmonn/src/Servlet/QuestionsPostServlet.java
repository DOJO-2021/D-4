package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuestionsDao;
import model.Question;
import model.Result;



/**
 * Servlet implementation class QuestionsPostServlet
 */
@WebServlet("/QuestionsPostServlet")
public class QuestionsPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletRequest request;

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
		  // リクエストパラメータを取得する?
    	request.setCharacterEncoding("UTF-8");
	    String q_title = request.getParameter("question_title");
	    String q_contents = request.getParameter("question_contents");

	    // 質問タグを5つ
	    String q_tag01 = request.getParameter("question_tag1");
	    String q_tag02 = request.getParameter("question_tag2");
	    String q_tag03 = request.getParameter("question_tag3");
	    String q_tag04 = request.getParameter("question_tag4");
	    String q_tag05 = request.getParameter("question_tag5");

		// 質問タグを最低1つ、最大5つ選択する

		// 添付ファイル

	    // 質問タグが1つも入力されていなかった場合、アラートを表示し、データ送信されずに元の入力画面に戻る。

	    // 登録処理 question dao
	    QuestionsDao QDao = new QuestionsDao();
	    if (QDao.insertQRecord(new Question(user_id, password, user_name, company, user_category))) {	// 登録成功
			request.setAttribute("result",
			new Result("登録成功！"));
	    	} //resultのbeansがないので赤線が出る。作成するか相談する。
	     	else {
			request.setAttribute("result",
			new Result("登録失敗！"));
	    	}

		// トップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
		dispatcher.forward(request, response);



		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}




	}



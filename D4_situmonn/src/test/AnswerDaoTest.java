package test;

import java.util.List;

import dao.AnswersDao;
import model.Answer;

public class AnswerDaoTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		AnswersDao dao = new AnswersDao();

				// insert()のテスト
				System.out.println("---------- insert()のテスト ----------");
				Answer insRec = new Answer(1, 1, "Test", "Test", null);
				if (dao.insert(insRec)) {
					System.out.println("登録成功！");
				}
				else {
					System.out.println("登録失敗！");
					}

				// select()のテスト
				System.out.println("---------- select()のテスト ----------");
				List<Answer> cardList = dao.List(1);
				for (Answer card : cardList) {
					System.out.println(card.getAns_contents());
					System.out.println(card.getUser_name());
					System.out.println();
					System.out.println();
				}

	}
}

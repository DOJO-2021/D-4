package test;

import java.util.List;

import dao.QuestionsDao;
import model.Question;

public class QuestionsDaoTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		QuestionsDao dao = new QuestionsDao();

		// select()のテスト
		//マイページ一覧表示時
		System.out.println("---------- select()のテスト ----------");
		List<Question> cardList = dao.selectMyQList("Test");
		for (Question card : cardList) {
			System.out.println(card.getQ_id());
			System.out.println(card.getQ_title());
			System.out.println(card.getQ_contents());
			System.out.println(card.getQ_tag01());
			System.out.println(card.getQ_tag02());
			System.out.println(card.getQ_tag03());
			System.out.println(card.getQ_tag04());
			System.out.println(card.getQ_tag05());
			System.out.println(card.getQ_date());
			System.out.println(card.getDone_tag());
			System.out.println();
			System.out.println();
		}

		//検索一覧から質問詳細移動時 & マイページから質問詳細移動時用
		List<Question> cardList2 = dao.selectQDetail(0);
		for (Question card : cardList2) {
			System.out.println(card.getQ_id());
			System.out.println(card.getQ_title());
			System.out.println(card.getQ_contents());
			System.out.println(card.getQ_tag01());
			System.out.println(card.getQ_tag02());
			System.out.println(card.getQ_tag03());
			System.out.println(card.getQ_tag04());
			System.out.println(card.getQ_tag05());
			System.out.println(card.getUser_id());
			System.out.println(card.getQ_file());
			System.out.println(card.getQ_date());
			System.out.println(card.getDone_tag());
			System.out.println(card.getCounter());
			System.out.println(card.getUser_name());
			System.out.println();
			System.out.println();
		}

		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Question insRec = new Question(1, "Test", "Test", "Test", "Test", "Test", "Test", "Test", "Test", "Test", null, 1, 1, "");
		//質問投稿用
		if (dao.insertQRecord(insRec)) {
			System.out.println("登録成功！");
		}
		else {
			System.out.println("登録失敗！");
		}

		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		//質問詳細移動時のカウント回数+1
		if (dao.updateCountup(0)) {
			System.out.println("更新成功！");
		}
		else {
			System.out.println("更新失敗！");
		}

		//質問の編集確定時
		Question upRec = new Question(0, "TEST", "TEST", "TEST", "TEST", "TEST", "TEST", "TEST", "TEST", 1);
		if (dao.updateQEdit(upRec)) {
			System.out.println("更新成功！");
		}
		else {
			System.out.println("更新失敗！");
		}
	}
}

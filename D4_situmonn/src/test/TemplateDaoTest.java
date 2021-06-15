package test;

import java.util.List;

import dao.TemplateDao;
import model.Template;

public class TemplateDaoTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		TemplateDao dao = new TemplateDao();

		// select()のテスト
				System.out.println("---------- select()のテスト ----------");
				List<Template> cardList = dao.Template();
				for (Template card : cardList) {
					System.out.println(card.getTemp_contents());
				}
	}

}

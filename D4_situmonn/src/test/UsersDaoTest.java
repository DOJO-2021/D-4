package test;

import java.util.List;

import dao.UsersDao;
import model.User;

public class UsersDaoTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		UsersDao dao = new UsersDao();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		//ログインチェックのテスト
		boolean cardListLogin = dao.isLoginOK(null, null);
		if(cardListLogin == true) {
			System.out.println("ログイン成功");
		}
		else {
			System.out.println("ログイン失敗");
		}

		//登録チェックのテスト
		boolean cardListCheck = dao.insertcheck(null);
		if(cardListCheck == true) {
			System.out.println("かぶりなし");
		}
		else {
			System.out.println("かぶりあり");
		}

		List<User> cardList = dao.select(null);
		for (User card : cardList) {
			System.out.println(card.getUser_id());
			System.out.println(card.getUser_name());
			System.out.println(card.getPassword());
			System.out.println(card.getUser_category());
			System.out.println(card.getCompany());
			System.out.println();
			System.out.println();
		}

		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		User insRec = new User("Test", "Test", "Test", "Test", "Test");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
		}
		else {
			System.out.println("登録失敗！");
			}

		// 挿入したレコードのIDを取得する（この後で更新と削除をするため）
		String insId = dao.select(insRec.getUser_id()).get(0).getUser_id();

		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		User upRec = new User(insId, "変更", "変更", "変更", "変更");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
		}
		else {
			System.out.println("更新失敗！");
		}

	}

}

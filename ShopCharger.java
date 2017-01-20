import java.util.*;

class ShopCharger {

	// 挿入している学生証
	private StudentCard insertedStudentCard;
	// チャージ履歴
	private ArrayList<HashMap<String,Object>> chargeHistoryList = new ArrayList<HashMap<String,Object>>();

	// チャージ履歴の記録上限
	private static final int CHARGEHISTORY_MAX = 5;

	public ShopCharger() {}
	
	// 学生証を挿入する
	public void insertStudentCard(StudentCard studentCard) {
		insertedStudentCard = studentCard;
	}

	// 学生証にお金をチャージする
	public void chargeMoney(int value) {
		if(insertedStudentCard == null) {
			System.out.println("\n学生証が挿入されていません");
			return;
		}
		// お金のチャージ
		insertedStudentCard.chargeAccountBalance(value);
		// 学生証の残高の表示
		printAccountBalance();
		// チャージ履歴の記録
		saveChargeHistory();
		// チャージ履歴の表示
		printChargeHistoryList();
	}

	// 挿入されている学生証の残高を表示する
	public void printAccountBalance() {
		if(insertedStudentCard == null) {
			System.out.println("\n学生証が挿入されていません");
			return;
		}
		System.out.println("\n残金を表示します。");
		System.out.println("name: " + insertedStudentCard.getName());
		System.out.println("balance: " + insertedStudentCard.getAccountBalance());
	}

	// チャージ履歴を記録する
	private void saveChargeHistory() {
		HashMap<String,Object> chargeHistory = new HashMap<String,Object>();
		chargeHistory.put(ChargeHistoryKey.CHARGE_ID.toString(), Math.abs(UUID.randomUUID().hashCode()));
		chargeHistory.put(ChargeHistoryKey.USER_ID.toString(), insertedStudentCard.getNumber());
		chargeHistory.put(ChargeHistoryKey.DATE.toString(), Calendar.getInstance());
		chargeHistory.put(ChargeHistoryKey.BALANCE.toString(), insertedStudentCard.getAccountBalance());

		chargeHistoryList.add(0, chargeHistory);

		// 履歴の記録上限を設定
		if(chargeHistoryList.size() > CHARGEHISTORY_MAX) {
			chargeHistoryList.remove(chargeHistoryList.size()-1);
		}
	}

	// チャージ履歴を表示する
	private void printChargeHistoryList() {
		System.out.println("\n最新のチャージ履歴を表示します。");
		for(HashMap<String,Object> chargeHistory: chargeHistoryList) {
			System.out.print("charge_id: " + chargeHistory.get(ChargeHistoryKey.CHARGE_ID.toString()));
			System.out.print(" , user_id: " + chargeHistory.get(ChargeHistoryKey.USER_ID.toString()));
			Calendar date = (Calendar)chargeHistory.get(ChargeHistoryKey.DATE.toString());
			System.out.print(" , date: " + date.getTime());
			System.out.println(" , balance: " + chargeHistory.get(ChargeHistoryKey.BALANCE.toString()));	
		}
	}
}
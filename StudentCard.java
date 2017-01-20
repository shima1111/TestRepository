import java.util.*;

class StudentCard {	

	private static ArrayList<StudentCard> studentCardList = new ArrayList<StudentCard>();

	private String name;
	private int number;
	private int accountBalance = 0;

	StudentCard(String name, int number) {
		this.name = name;
		this.number = number;
		StudentCard.studentCardList.add(this);
		// System.out.println("studentcards:" + StudentCard.studentCards.size());
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public static StudentCard getStudentCard(int studentId) {
		return StudentCard.studentCardList.get(studentId);
	}

	public void chargeAccountBalance(int value) {
		accountBalance += value;
	}

}

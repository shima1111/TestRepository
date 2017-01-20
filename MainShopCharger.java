import java.util.*;

class MainShopCharger {

    public static void main(String[] args){
		StudentCard card1 = new StudentCard("tanaka", 001);
		StudentCard card2 = new StudentCard("watanabe", 002);

		ShopCharger shopCharger = new ShopCharger();

		shopCharger.insertStudentCard(card1);
		shopCharger.chargeMoney(2000);
		shopCharger.chargeMoney(3000);
		shopCharger.insertStudentCard(card2);
		shopCharger.chargeMoney(4500);
		shopCharger.chargeMoney(3000);
		shopCharger.insertStudentCard(card1);
		shopCharger.chargeMoney(1000);
		shopCharger.chargeMoney(1000);
    }

}
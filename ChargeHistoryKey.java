public enum ChargeHistoryKey {
	
	CHARGE_ID("charge_id"),
	USER_ID("user_id"),
	DATE("date"),
	BALANCE("balance");

	private final String key;
 
    private ChargeHistoryKey(String key) {
        this.key = key;
    }

	public String toString() {
        return this.key;
    }
}

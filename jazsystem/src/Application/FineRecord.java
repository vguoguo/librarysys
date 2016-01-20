package Application;

public class FineRecord {
	public static double fine_per_day=1;
	private int late_dates;
	public FineRecord(int late_dates) {
		super();
		this.late_dates = late_dates;
	}
	public static double getFine_per_day() {
		return fine_per_day;
	}
	public int getLate_dates() {
		return late_dates;
	}
	public void setLate_dates(int late_dates) {
		this.late_dates = late_dates;
	}
	
}

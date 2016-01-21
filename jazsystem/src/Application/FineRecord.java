package Application;

import java.io.Serializable;

public class FineRecord implements Serializable{
	public static double fine_per_day=1.5;
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
	public double calc_Fine() {
		return this.late_dates*fine_per_day;
	}
}

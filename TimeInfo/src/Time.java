import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time {
	private String dateTime;

	public Time() {
		setDateTime(2000, 1, 1, 0, 0, 0);
	}

	public Time(int year) {
		setDateTime(year, 1, 1, 0, 0, 0);
	}

	public Time(int year, int month) {
		setDateTime(year, month, 1, 0, 0, 0);
	}

	public Time(int year, int month, int day) {
		setDateTime(year, month, day, 0, 0, 0);
	}

	public Time(int year, int month, int day, int hour) {
		setDateTime(year, month, day, hour, 0, 0);
	}

	public Time(int year, int month, int day, int hour, int min) {
		setDateTime(year, month, day, hour, min, 0);
	}

	public Time(int year, int month, int day, int hour, int min, int sec) {
		setDateTime(year, month, day, hour, min, sec);
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(int year, int month, int day, int hour, int min,int sec) {
		
		this.dateTime = String.format("%d.%d.%d %d.%d.%d.", year, month, day,
				hour, min, sec);
	}

	public String now() {
		DateFormat dateTime = new SimpleDateFormat("yy.MM.dd hh:mm:ss");

		Calendar cal = Calendar.getInstance();

		return dateTime.format(cal.getTime());
	}

	@Override
	public String toString() {
		return dateTime;
	}
}

package GetlandEstate.pojos;

import java.io.Serializable;

public class TourTimepojo implements Serializable {
	private int hour;
	private int minute;
	private int second;
	private int nano;

	public TourTimepojo() {
	}

	public TourTimepojo(int hour, int minute, int second, int nano) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.nano = nano;
	}

	public void setHour(int hour){
		this.hour = hour;
	}

	public int getHour(){
		return hour;
	}

	public void setMinute(int minute){
		this.minute = minute;
	}

	public int getMinute(){
		return minute;
	}

	public void setSecond(int second){
		this.second = second;
	}

	public int getSecond(){
		return second;
	}

	public void setNano(int nano){
		this.nano = nano;
	}

	public int getNano(){
		return nano;
	}

	@Override
 	public String toString(){
		return 
			"TourTimepojo{" + 
			"hour = '" + hour + '\'' + 
			",minute = '" + minute + '\'' + 
			",second = '" + second + '\'' + 
			",nano = '" + nano + '\'' + 
			"}";
		}
}
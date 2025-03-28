package GetlandEstate.pojos;

import java.io.Serializable;

public class US01TourRequestpojo implements Serializable {
	private String tourDate;
	private TourTimepojo tourTime;
	private int advertId;

	public US01TourRequestpojo() {

	}

	public US01TourRequestpojo(String tourDate, TourTimepojo tourTime, int advertId) {
		this.tourDate = tourDate;
		this.tourTime = tourTime;
		this.advertId = advertId;
	}

	public void setTourDate(String tourDate){
		this.tourDate = tourDate;
	}

	public String getTourDate(){
		return tourDate;
	}

	public void setTourTime(TourTimepojo tourTime){
		this.tourTime = tourTime;
	}

	public TourTimepojo getTourTime(){
		return tourTime;
	}

	public void setAdvertId(int advertId){
		this.advertId = advertId;
	}

	public int getAdvertId(){
		return advertId;
	}

	@Override
 	public String toString(){
		return 
			"US01TourRequestpojo{" + 
			"tourDate = '" + tourDate + '\'' + 
			",tourTime = '" + tourTime + '\'' + 
			",advertId = '" + advertId + '\'' + 
			"}";
		}
}
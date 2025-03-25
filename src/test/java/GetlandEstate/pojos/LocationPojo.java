package GetlandEstate.pojos;

import java.io.Serializable;

public class LocationPojo {
	private double lat;
	private double lng;

	public LocationPojo() {
	}

	public LocationPojo(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}

	public void setLat(double lat){
		this.lat = lat;
	}

	public double getLat(){
		return lat;
	}

	public void setLng(double lng){
		this.lng = lng;
	}

	public double getLng(){
		return lng;
	}

	@Override
 	public String toString(){
		return 
			"LocationPojo{" + 
			"lat = '" + lat + '\'' + 
			",lng = '" + lng + '\'' + 
			"}";
		}
}
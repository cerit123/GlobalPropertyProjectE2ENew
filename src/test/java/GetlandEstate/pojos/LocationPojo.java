package GetlandEstate.pojos;

import java.io.Serializable;

public class LocationPojo implements Serializable {
	private Object lat;
	private Object lng;

	public void setLat(Object lat){
		this.lat = lat;
	}

	public Object getLat(){
		return lat;
	}

	public void setLng(Object lng){
		this.lng = lng;
	}

	public Object getLng(){
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
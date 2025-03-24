package GetlandEstate.pojos;

import java.io.Serializable;

public class US12CountryPojo implements Serializable {
	private int id;
	private String name;
	private LocationPojo location;

	public US12CountryPojo() {
	}

	public US12CountryPojo(LocationPojo location, int id, String name) {
		this.location = location;
		this.id = id;
		this.name = name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLocation(LocationPojo location){
		this.location = location;
	}

	public LocationPojo getLocation(){
		return location;
	}

	@Override
 	public String toString(){
		return 
			"US12CountryPojo{" + 
			"id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			",location = '" + location + '\'' + 
			"}";
		}
}
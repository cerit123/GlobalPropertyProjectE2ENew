package GetlandEstate.pojos;

import java.io.Serializable;

public class Us04postRequestPayloadPOJO implements Serializable {
	private String title;

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public Us04postRequestPayloadPOJO() {
	}

	public Us04postRequestPayloadPOJO(String title) {
		this.title = title;
	}

	@Override
 	public String toString(){
		return 
			"Us04postRequestPOJO{" + 
			"title = '" + title + '\'' + 
			"}";
		}
}
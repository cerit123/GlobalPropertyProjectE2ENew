package GetlandEstate.pojos;

public class US11_DB_logsPojo {

    public int id;
    public String created_at;
    public String message;
    public int advert_id;
    public int user_id;

    public US11_DB_logsPojo() {}

    public US11_DB_logsPojo(int id, String created_at, String message, int advert_id, int user_id) {
        this.id = id;
        this.created_at = created_at;
        this.message = message;
        this.advert_id = advert_id;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAdvert_id() {
        return advert_id;
    }

    public void setAdvert_id(int advert_id) {
        this.advert_id = advert_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }




}

package GetlandEstate.pojos;

public class US14_DB_tour_requestsPojo {

    public int id;
    public String created_at;
    public String updated_at;
    public int status;
    public String tour_date;
    public String tour_time;
    public int advert_id;
    public int guest_user_id;
    public int owner_user_id;


    public US14_DB_tour_requestsPojo() {
    }

    public US14_DB_tour_requestsPojo(int id, String created_at, String updated_at, int status, String tour_date, String tour_time, int advert_id, int guest_user_id, int owner_user_id) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.status = status;
        this.tour_date = tour_date;
        this.tour_time = tour_time;
        this.advert_id = advert_id;
        this.guest_user_id = guest_user_id;
        this.owner_user_id = owner_user_id;
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

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTour_date() {
        return tour_date;
    }

    public void setTour_date(String tour_date) {
        this.tour_date = tour_date;
    }

    public String getTour_time() {
        return tour_time;
    }

    public void setTour_time(String tour_time) {
        this.tour_time = tour_time;
    }

    public int getAdvert_id() {
        return advert_id;
    }

    public void setAdvert_id(int advert_id) {
        this.advert_id = advert_id;
    }

    public int getGuest_user_id() {
        return guest_user_id;
    }

    public void setGuest_user_id(int guest_user_id) {
        this.guest_user_id = guest_user_id;
    }

    public int getOwner_user_id() {
        return owner_user_id;
    }

    public void setOwner_user_id(int owner_user_id) {
        this.owner_user_id = owner_user_id;
    }
}

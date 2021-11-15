package group9.group9;
@Entity
public class ReservationEntity {

    private int id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String date;
    private String time;
    private int numOfGuests;
    private boolean isHoliday;


    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public int getNumOfGuests() {
        return numOfGuests;
    }
    public void setNumOfGuests(int numOfGuests) {
        this.numOfGuests = numOfGuests;
    }
    public boolean isHoliday() {
        return isHoliday;
    }
    public void setHoliday(boolean isHoliday) {
        this.isHoliday = isHoliday;
    }
}

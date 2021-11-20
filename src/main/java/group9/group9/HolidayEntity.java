package group9.group9;

import javax.persistence.*;

@Entity
public class HolidayEntity {
   
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int holiday_id;

    private String date;

    private boolean isHoliday;

    public int getHoliday_id() {
        return holiday_id;
    }

    public void setHoliday_id(int holiday_id) {
        this.holiday_id = holiday_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public void setHoliday(boolean isHoliday) {
        this.isHoliday = isHoliday;
    }

    @Override
    public String toString() {
        return "HolidayEntity [date=" + date + ", holiday_id=" + holiday_id + ", isHoliday=" + isHoliday + "]";
    }

    
    



}

package group9.group9;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.*;

@Controller
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    

    @Autowired
    HolidayRepository holidayRepository;

    @GetMapping("/reservation")
	public String reservation(Model model) {
        
        ReservationModel reservationModel = new ReservationModel();
        model.addAttribute("reservationModel", reservationModel);

        return "reservation";
	}

    @PostMapping("/reservation")
    public String reservationSubmit(@ModelAttribute ReservationModel reservationModel, HttpServletResponse response) {
        
        /* input validation for reservation variable go here */

        //Carry over variable from the Model to the Entity

        return "redirect:/reservation";
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.POST, params = "checkavailability")
    public String checkAvailability(Model model, @ModelAttribute ReservationModel reservationModel, HttpServletRequest request) {
        
        /* input validation for reservation variable go here */
        //also check for table availability


        return "reservation";
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.POST, params = "finalizereservation")
    public String finalizeReservation(Model model, @ModelAttribute ReservationModel reservationModel, HttpServletRequest request) {

        //Retrieve profile info from UserInfoRepository and combine it with the variables from the reservation entity
        // and add a new reservation entity to the repository here

        ReservationEntity newReservationEntity = new ReservationEntity();

        newReservationEntity.setFullName(reservationModel.getFullName());
        newReservationEntity.setPhoneNumber(reservationModel.getPhoneNumber());
        newReservationEntity.setEmail(reservationModel.getEmail());
        newReservationEntity.setDate(reservationModel.getDate());
        newReservationEntity.setTime(reservationModel.getTime());
        newReservationEntity.setNumOfGuests(Integer.parseInt(reservationModel.getNumOfGuests()));
        //also add isHoliday info here
    

        boolean valid=isValidDate (reservationModel.getDate());
        boolean isholiday=isHolidayToday(reservationModel.getDate());
        newReservationEntity.setHoliday(isholiday);
        
        if(valid && isholiday){
            return "payment";
        }
        else{
           return "reservation"; 
        }
    
    }




///// This method  will validate the date format
public boolean isValidDate (String date){
    boolean flag=false;
    String year="";
    String day="";
    String month="";
 for(int i=0;i<10;i++){
   if(i<4){
     year= year+date.charAt(i);
   }
   else if(i>4 && i<7){
       month=month+date.charAt(i);

   }
   else if (i>7){
   
   day=day+date.charAt(i);
   }
 
 else{
     
 }
}
//////////////////////////////converting String to integer 
 int y=Integer.parseInt(year);
 int m=Integer.parseInt(month);
 int d=Integer.parseInt(day);
///////////////////////////////
if(y>2020 && m>0 && m<13 && d>0 && d<31){
flag=true;
}
else{
    flag=false;
}
///////////////////////
if(flag){
    return true;
}
else{
    return false;
}
 
}


///this method will check if Holiday or not:
public boolean isHolidayToday(String date){

    HolidayEntity holidayList=holidayRepository.findByDate(date);
  
     boolean flag=holidayList.isHoliday();

     if(flag){
         System.out.println(flag);
         return true;
     }
     else{
        System.out.println(flag);
         return false;
     } 
     
}







}






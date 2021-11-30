package group9.group9;

//import java.util.List;

//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletResponse;


import java.util.Arrays;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.*;

@Controller
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/reservation")
	public String reservation(Model model, HttpServletRequest request) {
        
        ReservationModel reservationModel = new ReservationModel();
        model.addAttribute("reservationModel", reservationModel);
        model.addAttribute("validationError", ""); //nothing for the time being

        // Inputs are good, so lets fetch the cookie
        Optional<String> userIdCookie = Arrays.stream(request.getCookies())
        .filter(cookie -> "user-id".equals(cookie.getName()))
        .map(Cookie::getValue)
        .findFirst();

        model.addAttribute("guestStatus", "");

        if (!userIdCookie.isPresent()) {    //this is a guest user
            model.addAttribute("guestStatus", "You are reseving as a guest user");
        }

        return "reservation";
	}

 
    @RequestMapping(value = "/reservation", method = RequestMethod.POST, params = "showAvailableTables")
    public String showAvaliableTables(Model model, @ModelAttribute ReservationModel reservationModel, HttpServletRequest request) {
        
        /* input validation for reservation variable go here */
        //also check for table availability

        if (reservationModel.getFullName() == "" || 
            reservationModel.getFullName().length() > 50 ||
            !isNumber(reservationModel.getPhoneNumber()) ||
            !isValidEmailAddress(reservationModel.getEmail()) ||
            !isNumber(reservationModel.getNumOfGuests()) ||
            (isNumber(reservationModel.getNumOfGuests()) && !(Integer.parseInt(reservationModel.getNumOfGuests()) > 0)))
        {
            model.addAttribute("validationError", "You have entered invalid parameter. Please try again.");

            return "reservation";
        }

        //get to cookie to find out the userid for this user
        Cookie cookie1[] = request.getCookies();
        String userid="";
        for(int i=0; i<cookie1.length; i++) {
            userid = cookie1[i].getValue();
            try{
                Integer.parseInt(userid);
            }
            catch(NumberFormatException e)
            {
                userid=null;
            }
            if(userid != null)
            {
                break;
            }
        }

        ReservationEntity newReservationEntity = new ReservationEntity();

        newReservationEntity.setFullName(reservationModel.getFullName());
        newReservationEntity.setPhoneNumber(reservationModel.getPhoneNumber());
        newReservationEntity.setEmail(reservationModel.getEmail());
        newReservationEntity.setDate(reservationModel.getDate());
        newReservationEntity.setTime(reservationModel.getTime());
        newReservationEntity.setNumOfGuests(Integer.parseInt(reservationModel.getNumOfGuests()));
        newReservationEntity.setUserId(Integer.parseInt(userid));

        reservationRepository.save(newReservationEntity);


    //     //also add isHoliday info here

        return "redirect:/displayAvailableTable";
    }

    private boolean isNumber(String str){
        boolean flag = true;
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i)) == false){
                flag = false;
                break;
            }
        }
        return flag;
    }
    //source: https://stackoverflow.com/questions/624581/what-is-the-best-java-email-address-validation-method
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }



}

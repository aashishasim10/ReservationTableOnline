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

@Controller
public class ReservationController {


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

        ReservationEntity newReservationEntity = new ReservationEntity();

        newReservationEntity.setFullName(reservationModel.getFullName());
        newReservationEntity.setPhoneNumber(reservationModel.getPhoneNumber());
        newReservationEntity.setEmail(reservationModel.getEmail());
        newReservationEntity.setDate(reservationModel.getDate());
        newReservationEntity.setTime(reservationModel.getTime());
        newReservationEntity.setNumOfGuests(Integer.parseInt(reservationModel.getNumOfGuests()));
        //also add isHoliday info here


        return "redirect:/reservation";
    }

}

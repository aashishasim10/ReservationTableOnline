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
        model.addAttribute("registration", reservationModel);
        return "reservation";
	}

    @PostMapping("/reservation")
    public String reservationSubmit(@ModelAttribute LoginModel login, HttpServletResponse response) {
    

        return "redirect:/reservation";
    }

}

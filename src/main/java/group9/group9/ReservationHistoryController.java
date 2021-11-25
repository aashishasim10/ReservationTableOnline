package group9.group9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.*;

@Controller
public class ReservationHistoryController {
    @Autowired
    private ReservationRepository reservationRepository;
<<<<<<< HEAD
    @GetMapping("/reservation")
=======
    @GetMapping("/reservationhistory")
>>>>>>> main

    public String history(Model model, HttpServletRequest request) {
        Cookie cookie[] = request.getCookies();
        String userid="";
        for(int i=0; i<cookie.length; i++) {
            userid = cookie[i].getValue();
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
<<<<<<< HEAD

        model.addAttribute("quotes", ReservationRepository.findByUserid(Integer.parseInt(userid)));
=======
        model.addAttribute("quotes", reservationRepository.findByUserid(Integer.parseInt(userid)));
>>>>>>> main
        return "reservationHistory";
    }
}
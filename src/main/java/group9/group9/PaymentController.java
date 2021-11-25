package group9.group9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PaymentController {
   
// @Autowired 
// PaymentRepository pr;

// @Autowired 
// PaymentEntity pe;



@GetMapping("/displayPayment")
public String showPayment(Model model){
 PaymentModel payment =new PaymentModel();
 model.addAttribute("payementInfo", payment);

    return "payment";
}




 @RequestMapping(value="/cardInformation",method=RequestMethod.POST)   
public String savePayment(@ModelAttribute("paymentModel")PaymentModel payment,ModelMap m){
   


return null;
}










}

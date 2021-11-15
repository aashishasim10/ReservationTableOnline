package group9.group9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PaymentController {
   
@Autowired 
PaymentRepository pr;

@Autowired 
PaymentEntity pe;

 @RequestMapping(value="/cardInformation",method=RequestMethod.POST)   
public String savePayment(@ModelAttribute("paymentModel")PaymentModel payment,ModelMap m){
   
    pe.setCardName(payment.getCardName());
       //pr.save(payment);


return null;
}










}

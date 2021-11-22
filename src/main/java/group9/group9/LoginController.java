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

@Controller
public class LoginController {


    @GetMapping("/login")
	public String login(Model model) {
        LoginModel loginModel = new LoginModel();
        model.addAttribute("loginForm", loginModel);
        return "login";
	}

    /*@PostMapping("/verifiedlogin")
    public String loginSubmit(@ModelAttribute("loginModel")LoginModel loginModel) {
     

        return "displayAvailableTable";
    }*/


    





    // @PostMapping("/login")
    // public String (@ModelAttribute LoginModel login, HttpServletResponse response) {
    

    //     return "redirect:/login";
    // }
}

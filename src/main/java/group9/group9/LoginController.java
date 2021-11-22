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

  //@Autowired
  //UserEntity userEntity;

  @Autowired
  UserRepository userRepository;



    @GetMapping("/login")
	public String login(Model model) {
        LoginModel loginModel = new LoginModel();
        model.addAttribute("loginForm", loginModel);
        return "login";
	}




    /// This method check the user is in system 
    @PostMapping("/verifiedLogin")
    public String loginSubmit(@ModelAttribute("loginModel")LoginModel loginModel,Model model) {
        UserEntity userEntity= new UserEntity();
        String email="";
        String pass="";
        boolean isAdmin=false;
    
     try{
     userEntity = userRepository.findByUsername(loginModel.getUsername());
     email=userEntity.getUsername();
     pass=userEntity.getPassword();
     isAdmin=userEntity.isAdmin();

      
     if(pass.equals(loginModel.getPassword())){
         if(isAdmin){
             return "addTable";
         }
        return "displayAvailableTable";
     }

     }
     catch(Exception e){

     String invalid="Your Username or Password didnot Match ";
     model.addAttribute("msg", invalid);
     return "login";

     }
     if(pass.equals(loginModel.getPassword())&& email.equals(loginModel.getUsername())){
        if(isAdmin){
            return "addTable";
        }
        return "displayAvailableTable";
     }
     else{
         return "login";
     }

      
    }


    





    // @PostMapping("/login")
    // public String (@ModelAttribute LoginModel login, HttpServletResponse response) {
    

    //     return "redirect:/login";
    // }
}

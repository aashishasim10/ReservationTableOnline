package group9.group9;

import java.util.Arrays;
import java.util.Optional;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping("/profile")
	public String profile(Model model, HttpServletRequest request) {
        UserInfoModel temp = new UserInfoModel();

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

        List<UserInfoEntity> userInfoEntity = userInfoRepository.findByUserid(Integer.parseInt(userid));

        //pre-fill client info if needed
        if (userInfoEntity.isEmpty()){
            temp.setFullName("");
            temp.setAddress1("");
            temp.setAddress2("");
            temp.setCity("");
            temp.setState("");
            temp.setZipcode("");
        }
        else{
            temp.setFullName(userInfoEntity.get(0).getFullName());
            temp.setAddress1(userInfoEntity.get(0).getAddress1());
            temp.setAddress2(userInfoEntity.get(0).getAddress2());
            temp.setCity(userInfoEntity.get(0).getCity());
            temp.setState(userInfoEntity.get(0).getState());
            temp.setZipcode(userInfoEntity.get(0).getZipcode());
        }

        model.addAttribute("temp", temp);

        return "profile";
	}

    @PostMapping("/profile")
    public String profileSubmit(HttpServletRequest request, @ModelAttribute UserInfoModel temp) {
        // Validate the inputs, if invalid refresh profile page

        if (temp.getZipcode().length() < 5 ||
            temp.getZipcode().length() > 9 ||
            !isNumber(temp.getZipcode()) ||
            temp.getAddress1() == "" || 
            temp.getAddress1().length() > 100 ||
            temp.getCity() == "" ||
            temp.getCity().length() > 100 ||
            temp.getState() == "" ||
            temp.getState().length() != 2 ||
            temp.getFullName() == "" || 
            temp.getFullName().length() > 50)
        {
            return "redirect:/profile";
        }

        // Inputs are good, so lets fetch the cookie
        Optional<String> userIdCookie = Arrays.stream(request.getCookies())
            .filter(cookie -> "user-id".equals(cookie.getName()))
            .map(Cookie::getValue)
            .findFirst();

        if (!userIdCookie.isPresent()) {
            // Cookie does not exist. No user is logged in.
            return "redirect:/login";
        }

        //get cookies to find out which user is editing their client info
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

        // Get the client info for the userId from the database.
        List<UserInfoEntity> userInfoEntity = userInfoRepository.findByUserid(Integer.parseInt(userid));

        if (userInfoEntity.isEmpty()) {
            // No user with that client id exists, lets create it.
            UserInfoEntity newUserInfo = new UserInfoEntity();

            newUserInfo.setFullName(temp.getFullName());
            newUserInfo.setAddress1(temp.getAddress1());
            newUserInfo.setAddress2(temp.getAddress2());
            newUserInfo.setCity(temp.getCity());
            newUserInfo.setState(temp.getState());
            newUserInfo.setZipcode(temp.getZipcode());
            newUserInfo.setUserId(Integer.parseInt(userid));

            userInfoRepository.save(newUserInfo);
        } else {
            // User client info exists, lets update it.
            userInfoEntity.get(0).setFullName(temp.getFullName());
            userInfoEntity.get(0).setAddress1(temp.getAddress1());
            userInfoEntity.get(0).setAddress2(temp.getAddress2());
            userInfoEntity.get(0).setCity(temp.getCity());
            userInfoEntity.get(0).setState(temp.getState());
            userInfoEntity.get(0).setZipcode(temp.getZipcode());

            userInfoRepository.save(userInfoEntity.get(0));
        }

        return "redirect:/reservation";
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
}


package group9.group9;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping("/registration")
	public String registration(Model model) {
        RegistrationModel registrationModel = new RegistrationModel();
        model.addAttribute("registration", registrationModel);
        return "registration";
	}
    
    @PostMapping("/registration")
    public String registrationSubmit(@ModelAttribute RegistrationModel registration, HttpServletResponse response) {
        if (registration.getUsername().equals("") || registration.getPassword().equals("")) {
            return "redirect:/registration";
        }

        List<UserEntity> clients = userInfoRepository.findByUsername(registration.getUsername());

        if (!clients.isEmpty()) {
            return "redirect:/registration";
        }

        UserEntity n = new UserEntity();
        n.setName(registration.getUsername());

        String hash = PasswordEncryption.hash(registration.getPassword());

        n.setPassword(hash);
        n = userInfoRepository.save(n);

        Cookie cookie = new Cookie("user-id", n.getId().toString());
        response.addCookie(cookie);

        return "redirect:/profile";
    }
}
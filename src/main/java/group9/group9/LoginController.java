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
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
	public String login(Model model) {
        LoginModel loginModel = new LoginModel();
        model.addAttribute("loginModel", loginModel);
        return "login";
	}

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute LoginModel loginModel, HttpServletResponse response) {

        List<UserEntity> users = userRepository.findByUsername(loginModel.getUsername());

        if (users.isEmpty()) {
            return "redirect:/login";
        }

        UserEntity user = users.get(0);

        String hash = PasswordEncryption.hash(loginModel.getPassword());

        if (!user.getPassword().equals(hash)) {
            return "redirect:/login";
        }

        Cookie cookie = new Cookie("user-id", user.getUserId().toString());
        response.addCookie(cookie);

        return "redirect:/fuelhistory";
    }

}


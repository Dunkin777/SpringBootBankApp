package bankapp.SpringBootBankApp.Controller;

import bankapp.SpringBootBankApp.Model.Role;
import bankapp.SpringBootBankApp.Model.User;
import bankapp.SpringBootBankApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;


@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam String username, @RequestParam String password, Model model){
        User userFromDb = userRepository.findByUsername(username);
        if (userFromDb !=null) {
            model.addAttribute("text", "Username is:" + username);
        return "registration";
        }
        User user = new User(username,password,true,Collections.singleton(Role.USER));
        //user.setUsername(username);
        //user.setPassword(password);
        //user.setActive(true);
        //user.setRoles(Collections.singleton(Role.USER)); //синглтон создаёт сет с одним значением
        userRepository.save(user);
        return "redirect:/login";
    }
}

package com.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dao.UserDao;
import com.model.User;

@Controller
public class UserController {
    @Autowired
    private UserDao userDAO;
    
	
	  @RequestMapping("/") public String signuppage() { return "signup"; }
	 

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignupForm(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        // Validate user input and save the user
        userDAO.inserOrUpdatetUser(user);
        redirectAttributes.addFlashAttribute("message", "User registered successfully!");
        return "redirect:/login";
    }
}

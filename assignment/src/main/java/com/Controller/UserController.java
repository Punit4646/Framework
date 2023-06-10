package com.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.Service.UserService;
import com.model.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ServletContext servletContext;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }
    @RequestMapping("/")
    public String registePage() {
    	return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("user") User user, @RequestParam("file") MultipartFile file) {
        // Save the uploaded profile picture
        if (!file.isEmpty()) {
            try {
                String uploadsDir = "/uploads/";
                String realPath = servletContext.getRealPath(uploadsDir);
                if (!new File(realPath).exists()) {
                    new File(realPath).mkdir();
                }
                String originalFilename = file.getOriginalFilename();
                String filePath = realPath + originalFilename;
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
                stream.write(bytes);
                stream.flush();
                stream.close();
                user.setProfilePic(uploadsDir + originalFilename);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, HttpServletRequest request) {
        // Perform login logic here
        // Retrieve user details from the database using userService.getUserByEmail(user.getEmail())
        // Compare the entered password with the stored password
        // If login is successful, set the user details in the session and redirect to the profile page

        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String showProfile(Model model, HttpServletRequest request) {
        // Retrieve user details from the session using request.getSession().getAttribute("user")
        // Add the user details to the model and return the profile view
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(@ModelAttribute("user") User user, @RequestParam("file") MultipartFile file) {
        // Update the user details in the database
        // If a new profile picture is uploaded, save it as described in the registration method

        return "redirect:/profile";
    }

    @GetMapping("/admin")
    public String showAdminPage(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin";
    }

    @PostMapping("/admin/delete/{userId}")
    public String deleteUser(@PathVariable("userId") int userId) {
        User user = userService.getUserById(userId);
        userService.deleteUser(user);
        return "redirect:/admin";
    }
}

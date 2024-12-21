package com.mvc.commerce.controllers;

import com.mvc.commerce.dao.UserDao;
import com.mvc.commerce.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class RegistrationController {
    Logger logger = Logger.getLogger(getClass().getName());

    private final UserDao userDao;

    public RegistrationController(UserDao userDao) {
        this.userDao = userDao;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }


    @PostMapping("/registerUser")
    public String registerUser(@Valid @ModelAttribute("newuser") User user, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "register";
        }
        userDao.save(user);
        logger.log(Level.FINE, "register {0}", user);
        model.addAttribute("dataSaved", "User register successfully");
        return "login";
    }
}

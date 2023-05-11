package com.weblab.magnetism.controller.mvc;

import com.weblab.magnetism.model.User;
import com.weblab.magnetism.service.interf.UserService;
import com.weblab.magnetism.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user) {
        return "auth/registration";
    }


    @PostMapping("/process-registration")
    public String processRegistration(@ModelAttribute("user") @Valid User user,
                                                    BindingResult bindingResult) {
        //check if user already exists
        userValidator.validate(user, bindingResult);

        if(bindingResult.hasErrors()){
            return "auth/registration";
        }
        userService.create(user);
        return "redirect:/auth/login";
    }
}

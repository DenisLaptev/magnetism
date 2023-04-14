package com.weblab.magnetism.controller.mvc;


import com.weblab.magnetism.model.User;
import com.weblab.magnetism.security.UserDetailsImpl;
import javax.security.auth.login.AccountNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(UserDetailsController.USER_DETAILS_URL)
public class UserDetailsController {

    public static final String USER_DETAILS_URL = "ui/user-details";
    public static final String USER_DETAILS_NAME = "user-details";

    String getEntityName() {
        return USER_DETAILS_NAME;
    }

    @GetMapping
    public String showRead(Model model) throws AccountNotFoundException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        if (userDetails == null) {
            throw new AccountNotFoundException("Account Error");
        }

        User user = userDetails.getUser();

        model.addAttribute("id", user.getId());
        return getEntityName() + "/read";
    }
}

package com.weblab.magnetism.controller.rest;

import com.weblab.magnetism.model.User;
import com.weblab.magnetism.security.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Denys Laptiev
 * Date: 12.05.2023
 */
@RestController
@RequestMapping(UserDetailsRestController.USER_DETAILS_REST_URL)
public class UserDetailsRestController {

    public static final String USER_DETAILS_REST_URL = "user-details";

    @GetMapping
    public ResponseEntity<User> findCurrentUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        if (userDetails == null) {
            return ResponseEntity.notFound().build();
        }

        User user = userDetails.getUser();

        return ResponseEntity.ok(user);
    }
}

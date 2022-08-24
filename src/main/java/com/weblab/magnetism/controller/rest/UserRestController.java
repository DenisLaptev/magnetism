package com.weblab.magnetism.controller.rest;

import com.weblab.magnetism.model.User;
import com.weblab.magnetism.service.interf.CRUDService;
import com.weblab.magnetism.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(UserRestController.USER_REST_URL)
public class UserRestController extends CRUDRestController<User, Long> {

    public static final String USER_REST_URL = "user";

    @Autowired
    private UserService userService;

    @Override
    CRUDService<User, Long> getService() {
        return userService;
    }
}

package com.weblab.magnetism.controller.mvc;

import com.weblab.magnetism.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(UserController.USER_URL)
public class UserController extends CRUDController<User, Long> {

    public static final String USER_URL = "ui/user";
    public static final String USER_NAME = "user";

    @Override
    String getEntityName() {
        return USER_NAME;
    }
}
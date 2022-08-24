package com.weblab.magnetism.controller.rest;

import com.weblab.magnetism.model.Role;
import com.weblab.magnetism.service.interf.CRUDService;
import com.weblab.magnetism.service.interf.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RoleRestController.ROLE_REST_URL)
public class RoleRestController extends CRUDRestController<Role, Long> {

    public static final String ROLE_REST_URL = "role";

    @Autowired
    private RoleService roleService;

    @Override
    CRUDService<Role, Long> getService() {
        return roleService;
    }
}

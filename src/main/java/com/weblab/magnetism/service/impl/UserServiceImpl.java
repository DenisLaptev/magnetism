package com.weblab.magnetism.service.impl;

import com.weblab.magnetism.model.Roles;
import com.weblab.magnetism.model.User;
import com.weblab.magnetism.model.UserRole;
import com.weblab.magnetism.repository.RoleRepository;
import com.weblab.magnetism.repository.UserRepository;
import com.weblab.magnetism.repository.UserRoleRepository;
import com.weblab.magnetism.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractCRUDService<User, Long> implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    CrudRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public void create(User user) {
        //encode password
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        //save user into user_table
        getRepository().save(user);

        //save user and role into user_role
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(roleRepository.findByTitle(Roles.ROLE_USER.name()).get().getId());
        userRoleRepository.save(userRole);
    }
}
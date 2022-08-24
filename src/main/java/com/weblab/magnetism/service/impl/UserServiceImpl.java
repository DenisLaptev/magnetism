package com.weblab.magnetism.service.impl;

import com.weblab.magnetism.model.User;
import com.weblab.magnetism.repository.UserRepository;
import com.weblab.magnetism.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractCRUDService<User, Long> implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    CrudRepository<User, Long> getRepository() {
        return userRepository;
    }
}
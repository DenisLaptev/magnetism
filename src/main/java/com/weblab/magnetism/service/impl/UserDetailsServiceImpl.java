package com.weblab.magnetism.service.impl;

import com.weblab.magnetism.model.User;
import com.weblab.magnetism.repository.UserRepository;
import com.weblab.magnetism.security.UserDetailsImpl;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = loadUserOptionalByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }
        return new UserDetailsImpl(user.get());
    }

    public Optional<User> loadUserOptionalByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

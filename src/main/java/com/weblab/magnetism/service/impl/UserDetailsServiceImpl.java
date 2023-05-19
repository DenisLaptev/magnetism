package com.weblab.magnetism.service.impl;

import com.weblab.magnetism.model.User;
import com.weblab.magnetism.model.UserRole;
import com.weblab.magnetism.repository.RoleRepository;
import com.weblab.magnetism.repository.UserRepository;
import com.weblab.magnetism.repository.UserRoleRepository;
import com.weblab.magnetism.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = loadUserOptionalByUsername(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }
        User user = userOptional.get();
        setAuthorities(user);
        return new UserDetailsImpl(user);
    }

    public Optional<User> loadUserOptionalByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    private void setAuthorities(User user) {
        Long userId = user.getId();

        List<UserRole> userRoles = (List<UserRole>) userRoleRepository.findAllByUserId(userId);

        List<Long> roleIds = userRoles.stream().map(userRole -> userRole.getRoleId()).collect(Collectors.toList());

        List<String> authorities = roleIds.stream().map(roleId -> roleRepository.findById(roleId).get().getTitle()).collect(Collectors.toList());

        user.setAuthorities(authorities);
    }
}

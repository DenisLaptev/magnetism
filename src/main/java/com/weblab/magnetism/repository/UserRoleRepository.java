package com.weblab.magnetism.repository;

import com.weblab.magnetism.model.UserRole;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Denys Laptiev
 * Date: 19.05.2023
 */
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    Iterable<UserRole> findAllByUserId(Long userId);
}


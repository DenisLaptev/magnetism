package com.weblab.magnetism.repository;

import com.weblab.magnetism.model.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    Iterable<UserRole> findAllByUserId(Long userId);
}
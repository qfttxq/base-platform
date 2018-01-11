package com.base.repository;

import com.base.entity.UserRole;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by qfttx on 2018/1/11.
 */
public interface UserRoleRepository extends JpaRepository<UserRole,String> {
}

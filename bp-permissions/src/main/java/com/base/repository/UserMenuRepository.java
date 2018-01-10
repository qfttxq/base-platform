package com.base.repository;

import com.base.entity.UserMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMenuRepository extends JpaRepository<UserMenu, String> {
}

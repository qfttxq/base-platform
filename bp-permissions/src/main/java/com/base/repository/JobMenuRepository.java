package com.base.repository;

import com.base.entity.JobMenu;
import com.base.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobMenuRepository extends JpaRepository<JobMenu, String> {
}

package com.base.repository;

import com.base.entity.UserJob;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by qfttx on 2018/1/11.
 */
public interface UserJobRepository extends JpaRepository<UserJob,String> {
}

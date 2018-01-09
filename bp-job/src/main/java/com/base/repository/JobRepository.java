package com.base.repository;

import com.base.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,String> {
}

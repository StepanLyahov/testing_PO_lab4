package com.stepan.todoistback.business.dao;

import com.stepan.todoistback.business.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
}

package com.stepan.todoistback.business.dao;

import com.stepan.todoistback.business.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}

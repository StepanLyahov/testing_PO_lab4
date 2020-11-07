package com.stepan.todoistback.business.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "project")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String title;

    @OneToMany(mappedBy = "projectId", fetch = FetchType.EAGER)
    List<TaskEntity> tasks;
}

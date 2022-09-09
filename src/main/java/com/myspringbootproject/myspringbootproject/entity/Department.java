package com.myspringbootproject.myspringbootproject.entity;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "department", schema = "my_schema")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Please add department's name")
    @Length(max = 10, min = 2)
    private String departmentName;
    private String getDepartmentAddress;
    private String getDepartmentCode;
}

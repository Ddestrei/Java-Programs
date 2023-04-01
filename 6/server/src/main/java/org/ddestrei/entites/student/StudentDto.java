package org.ddestrei.entites.student;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.ddestrei.entites.Roles;

@Getter
@Setter
@Builder
public class StudentDto {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private int age;
}

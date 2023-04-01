package org.ddestrei.services.student;

import org.ddestrei.entites.student.Student;
import org.ddestrei.entites.student.StudentDto;

import java.util.List;
import java.util.stream.Collectors;

public class StudentDtoMapper {
    private StudentDtoMapper(){}

    static public List<StudentDto> mapStudentsToDtos(List<Student> students){
        return students.stream()
                .map(student-> mapStudentToDto(student))
                .collect(Collectors.toList());
    }
    static private StudentDto mapStudentToDto(Student student){
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .surname(student.getSurname())
                .email(student.getEmail())
                .age(student.getAge())
                .build();
    }
}

package org.ddestrei.Second.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("This email is exist in db");
        }
        else {
            studentRepository.save(student);
        }
        System.out.println(student);
    }

    public void deleteStudent(Long id) {
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        }
        else {
            throw new IllegalStateException("This id isn`t exist in db");
        }
    }

    public void updateStudent(Long id, String name, String email) {
        if(studentRepository.existsById(id)){
            Optional<Student> opt = studentRepository.findById(id);
            Student s=opt.get();
            s.setName(name);
            s.setEmail(email);
            studentRepository.save(s);
        }
        else {
            throw new IllegalStateException("This id isn`t exist in db");
        }
    }
}

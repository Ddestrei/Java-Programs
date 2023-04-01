package org.ddestrei.services.student;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ddestrei.entites.student.Student;
import org.ddestrei.repositorys.StudentRepository;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class StudentService {
    private StudentRepository repository;
    @Transactional
    @CachePut(cacheNames = "SingleStudent", key="#result.email")
    public Student findByEmail(String email){
        Optional<Student> student = repository.findByEmail(email);
        if(student.isPresent()){
            return student.get();
        }
        else {
            throw new IllegalArgumentException("Student with this email isn`t exist in DB!!!");
        }
    }
    @Cacheable(cacheNames = "AllStudents")
    public List<Student> findAll(){
        return repository.findAll();
    }

    @Transactional
    @CachePut(cacheNames = "SingleStudent", key="#result.email")
    public boolean checkEmailIsInDB(String email){
        Optional<Student> student = repository.findByEmail(email);
        if(student.isPresent()){
            return true;
        }
        else {
            return false;
        }
    }

    public int add(StudentRequest request){
        if(checkEmailIsInDB(request.email())){
            log.info("Student with this "+request.email()+" email is in DB");
        }
        else {
            Student student = Student.builder()
                    .name(request.name())
                    .surname(request.surname())
                    .email(request.email())
                    .age(request.age())
                    .build();
            return repository.save(student).getId();
        }
        return -1;
    }

    @CacheEvict(cacheNames = "SingleStudent")
    public String deleteById(String email){
        Student student = repository.findByEmail(email).orElse(null);
        if(student == null){
            log.error("Student with this {} email not exist in db", email);
        }
        else {
            log.info("Student has been deleted!!!");
            repository.delete(student);
        }
        return "Student has been deleted!!!";
    }
    @Cacheable(cacheNames = "SingleStudent", key = "#email")
    public void changeData(StudentRequest request, String email){
        Student student = this.findByEmail(email);
        if(student == null){
            log.error("Student with this {} email not exist in DB", email);
        }
        else {
            student.setName(request.name());
            student.setSurname(request.surname());
            student.setAge(request.age());
            repository.save(student);
        }
    }
}

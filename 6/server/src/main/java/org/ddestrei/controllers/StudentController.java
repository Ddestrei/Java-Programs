package org.ddestrei.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ddestrei.entites.student.StudentDto;
import org.ddestrei.services.student.StudentDtoMapper;
import org.ddestrei.services.student.StudentRequest;
import org.ddestrei.services.student.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/student")
@Slf4j
public class StudentController {

    private StudentService service;

    @GetMapping("/HelloWorld")
    public String isWorking(){
        log.info("Client is connected!!!");
        return "Connected!!!";
    }

    @PostMapping("/addStudent")
    @ResponseBody
    public void addStudent(@RequestBody StudentRequest request){
        service.add(request);
    }

    @GetMapping("/getAllStudent")
    @ResponseBody
    public List<StudentDto> getAllStudent(){
        return StudentDtoMapper.mapStudentsToDtos(service.findAll());
    }

    @DeleteMapping("/deleteStudentByEmail")
    @ResponseBody
    public void deleteById(@RequestParam String email){
        service.deleteById(email);
        log.info("Student deleted!!!");
    }

    @PostMapping("/changeData")
    @ResponseBody
    public String changeStudent(@RequestParam String email ,@RequestBody StudentRequest request){
        log.info("Student`s data changed!!!");
        service.changeData(request,email);
        return "Done";
    }

}

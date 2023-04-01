package org.ddestrei.Second.student;

import org.hibernate.mapping.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student m = new Student(
                    "Mariam",
                     LocalDate.of(2000, Month.JANUARY,5),
                    "maraim@gmail.com"
            );

            Student a = new Student(
                    "Alex",
                     LocalDate.of(2004, Month.JANUARY,5),
                    "Alex@gmail.com"
            );
            studentRepository.save(m);
            studentRepository.save(a);
        };
    }
}

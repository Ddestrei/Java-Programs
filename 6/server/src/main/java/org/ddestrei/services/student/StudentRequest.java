package org.ddestrei.services.student;

public record StudentRequest(
        String name,
        String surname,
        String email,
        int age
        ) {}

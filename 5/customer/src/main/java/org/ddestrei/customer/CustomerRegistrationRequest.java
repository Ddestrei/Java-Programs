package org.ddestrei.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}

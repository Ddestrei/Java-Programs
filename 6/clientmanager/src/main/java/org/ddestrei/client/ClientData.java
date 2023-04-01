package org.ddestrei.client;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientData {
    String name;
    String surname;
    String email;
    int age;
}

package org.ddestrei.p3.mamy;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mamy")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Mama {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "imię")
    private String imie;
    @Column(name = "wiek")
    private int wiek;
}

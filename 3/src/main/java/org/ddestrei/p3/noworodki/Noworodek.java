package org.ddestrei.p3.noworodki;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "noworodki")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Noworodek {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "płeć")
    private String plec;
    @Column(name = "imię")
    private String imie;
    @Column(name = "data_urodzenia")
    private LocalDateTime data_urodzenia;
    @Column(name = "waga")
    private int waga;
    @Column(name = "wzrost")
    private int wzrost;
    @Column(name = "id_matki")
    private Long id_matki;

}

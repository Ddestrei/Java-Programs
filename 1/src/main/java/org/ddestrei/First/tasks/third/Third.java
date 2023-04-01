package org.ddestrei.First.tasks.third;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Third {
    @Id
    @Column(name = "id_pracownika")
    private Long id;
    @Column(name ="cena")
    private int cena;

    @Column(name ="imie")
    private String imie;

    @Column(name ="nazwisko")
    private String nazwisko;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return "Third{" +
                "cena=" + cena +
                ", imie=" + imie +
                ", nazwisko=" + nazwisko +
                '}';
    }
}

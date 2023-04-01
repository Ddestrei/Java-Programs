package org.ddestrei.First.tasks.first;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Entity
public class First {

    @Id
    @Column(name = "NrDomku")
    private int id;

    @Column(name = "liczba_dni")
    private int liczba_dni;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLiczba_dni() {
        return liczba_dni;
    }

    public void setLiczba_dni(int liczba_dni) {
        this.liczba_dni = liczba_dni;
    }

    @Override
    public String toString() {
        return "nr_domku: "+ id +
                "liczba_dni"+ liczba_dni;
    }
}

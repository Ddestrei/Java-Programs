package org.ddestrei.First.tasks.second;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface SecondTaskRepository extends JpaRepository<Second,Long> {
    @Query(value = "SELECT pracownicy.nazwisko" +
            "     , pracownicy.imie" +
            ", pracownicy.id_pracownika "+
            "  FROM pracownicy INNER JOIN" +
            "       rezerwacje ON pracownicy.id_pracownika=rezerwacje.id_pracownika" +
            " WHERE rezerwacje.nr_domku='2'" +
            " ORDER BY pracownicy.imie", nativeQuery = true)
    public Collection<Second> secondTask();
}

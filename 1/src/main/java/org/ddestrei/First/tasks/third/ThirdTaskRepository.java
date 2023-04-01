package org.ddestrei.First.tasks.third;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ThirdTaskRepository extends JpaRepository<Third ,Long> {
    @Query(value = "SELECT pracownicy.nazwisko" +
            "     , pracownicy.imie" +
            "     , pracownicy.id_pracownika" +
            "     , SUM(rezerwacje.liczba_dni*domki.cena_za_dobe) AS cena" +
            "  FROM pracownicy INNER JOIN" +
            "      (domki INNER JOIN" +
            "               rezerwacje ON rezerwacje.nr_domku=domki.nr_domku) ON pracownicy.id_pracownika=rezerwacje.id_pracownika" +
            " GROUP BY pracownicy.id_pracownika" +
            " ORDER BY SUM(rezerwacje.liczba_dni*domki.cena_za_dobe) DESC LIMIT 1 ;", nativeQuery = true)
    public Collection<Third> thirdTaks();
}

package org.ddestrei.First.tasks.fifth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
public interface FifthTaskRepository extends JpaRepository<Fifth,Long> {
    @Query(value="SELECT domki.nr_domku" +
            "     , MAX(rezerwacje.liczba_dni) AS ilosc" +
            "  FROM domki INNER JOIN" +
            "       rezerwacje ON rezerwacje.nr_domku=domki.nr_domku" +
            " GROUP BY domki.nr_domku;",nativeQuery = true)
    public Collection<Fifth> fifthTask();
}

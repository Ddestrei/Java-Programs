package org.ddestrei.First.tasks.fourth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface FourthTaskRepository extends JpaRepository<Fourth,Long> {
    @Query(value = "SELECT domki.garaz" +
            ", domki.nr_domku "+
            "     , COUNT(domki.nr_domku) AS ilosc" +
            "  FROM domki INNER JOIN" +
            "       rezerwacje ON rezerwacje.nr_domku=domki.nr_domku" +
            " GROUP BY domki.garaz", nativeQuery = true)
    public Collection<Fourth> forthTask();
}

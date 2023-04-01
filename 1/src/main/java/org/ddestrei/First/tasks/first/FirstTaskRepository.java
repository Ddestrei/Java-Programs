package org.ddestrei.First.tasks.first;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FirstTaskRepository extends JpaRepository<First, Integer> {
        @Query(value = "SELECT rezerwacje.nr_domku" +
                "     , COUNT(rezerwacje.liczba_dni) AS liczba_dni" +
                "  FROM rezerwacje" +
                " GROUP BY rezerwacje.nr_domku", nativeQuery = true)
        public Collection<First> firstTask();
}

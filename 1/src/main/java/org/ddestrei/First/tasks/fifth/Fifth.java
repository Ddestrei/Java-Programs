package org.ddestrei.First.tasks.fifth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Fifth {
    @Id
    @Column(name = "nr.domku")
    private long id;

    @Column(name = "ilosc")
    private int ilosc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}

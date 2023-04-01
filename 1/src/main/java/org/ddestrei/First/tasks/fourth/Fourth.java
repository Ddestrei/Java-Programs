package org.ddestrei.First.tasks.fourth;

import jakarta.persistence.*;

@Entity
@IdClass(Fourth.class)
public class Fourth {
    @Id
    @Column(name = "nr.domku")
    private Long id;

    @Column(name = "garaz")
    private String garaz;

    @Column(name = "ilosc")
    private int ilosc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGaraz() {
        return garaz;
    }

    public void setGaraz(String garaz) {
        this.garaz = garaz;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    @Override
    public String toString() {
        return "Fourth{" +
                "garaz='" + garaz + '\'' +
                ", ilosc=" + ilosc +
                '}';
    }
}

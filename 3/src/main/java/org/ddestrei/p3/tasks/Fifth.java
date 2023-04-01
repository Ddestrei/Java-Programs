package org.ddestrei.p3.tasks;

import org.ddestrei.p3.mamy.Mama;
import org.ddestrei.p3.noworodki.Noworodek;

import java.util.LinkedList;
import java.util.List;

public class Fifth {
    private List<Mama> mamy;
    private List<Noworodek> noworodki;
    public Fifth(List<Mama> mamy, List<Noworodek> noworodki){
        this.mamy=mamy;
        this.noworodki=noworodki;
    }

    public void task(){
        List<Noworodek> odp = new LinkedList<>();
        for (int i=0;i<noworodki.size(); i++){
            Noworodek x = noworodki.get(i);
            for (int j=0;j<noworodki.size(); j++){
                Noworodek y = noworodki.get(j);
                if(!x.getId().equals(y.getId())){
                    if(x.getId_matki().equals(y.getId_matki())&&x.getData_urodzenia().equals(y.getData_urodzenia())){
                        if(!existInOdp(odp,x)) {
                            odp.add(x);
                        }
                    }
                }
            }
        }
        odp.forEach(s->{
            System.out.println(s.toString());
        });
    }

    public boolean existInOdp(List<Noworodek> odp, Noworodek x){
        for (int k=0;k<odp.size(); k++){
            if(odp.get(k).getId_matki().equals(x.getId_matki())) return true;
        }
        return false;
    }
}

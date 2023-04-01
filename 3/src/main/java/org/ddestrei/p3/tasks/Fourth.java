package org.ddestrei.p3.tasks;

import org.ddestrei.p3.mamy.Mama;
import org.ddestrei.p3.noworodki.Noworodek;

import java.util.LinkedList;
import java.util.List;

public class Fourth {
    private List<Mama> mamy;
    private List<Noworodek> noworodki;
    public Fourth(List<Mama> mamy, List<Noworodek> noworodki){
        this.mamy=mamy;
        this.noworodki=noworodki;
    }

    public void task(){
        List<Noworodek> odp = new LinkedList<>();
        for (int i=0;i<noworodki.size(); i++){
            if(noworodki.get(i).getPlec().equals("c")) {
                for (int j = 0; j < mamy.size(); j++) {
                    if(noworodki.get(i).getId_matki().equals(mamy.get(j).getId())){
                        if(noworodki.get(i).getImie().equals(mamy.get(j).getImie())){
                            odp.add(noworodki.get(i));
                        }
                    }
                }
            }
        }
        odp.forEach(s->{
            System.out.println(s.toString());
        });
    }
}

package org.ddestrei.p3.tasks;

import org.ddestrei.p3.mamy.Mama;
import org.ddestrei.p3.noworodki.Noworodek;

import java.util.LinkedList;
import java.util.List;

public class Third {
    private List<Mama> mamy;
    private List<Noworodek> noworodki;
    public Third(List<Mama> mamy, List<Noworodek> noworodki){
        this.mamy=mamy;
        this.noworodki=noworodki;
    }

    public void task(){
        List<Mama> ponizej25= new LinkedList<>();
        for (int i=0;i<mamy.size(); i++){
            if(mamy.get(i).getWiek()<25) ponizej25.add(mamy.get(i));
        }
        List<Mama> odp = new LinkedList<>();
        for (int i=0;i<ponizej25.size(); i++){
            for (int j=0;j<noworodki.size(); j++){
                if(noworodki.get(j).getId_matki().equals(ponizej25.get(i).getId())){
                    if(noworodki.get(j).getWaga()>4000) {
                        odp.add(ponizej25.get(i));
                        break;
                    }
                }
            }
        }
        odp.forEach(s->{
            System.out.println(s.toString());
        });
    }
}

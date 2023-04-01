package org.ddestrei.p3.tasks;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.ddestrei.p3.mamy.Mama;
import org.ddestrei.p3.noworodki.Noworodek;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Second {
    private List<Mama> mamy;
    private List<Noworodek> noworodki;
    public Second(List<Mama> mamy, List<Noworodek> noworodki){
        this.mamy=mamy;
        this.noworodki=noworodki;
    }
    public void task(){
        HashMap<LocalDateTime,Integer> dni = new HashMap<>();
        for(int i=0;i<noworodki.size(); i++){
            Noworodek s = noworodki.get(i);
            if(dni.containsKey(s.getData_urodzenia())){
                int razy= dni.get(s.getData_urodzenia());
                razy+=1;
                dni.put(s.getData_urodzenia(),razy);
            }
            else {
                dni.put(s.getData_urodzenia(),1);
            }
        }
        LocalDateTime najData = null;
        int ileRazy=0;
        for (Map.Entry<LocalDateTime, Integer> s: dni.entrySet()){
            if(najData == null){
                najData=s.getKey();
                ileRazy=s.getValue();
            }
            else {
                if(ileRazy<s.getValue()){
                    najData=s.getKey();
                    ileRazy=s.getValue();
                }
            }
        }
        System.out.println(najData.toString());
        System.out.println(ileRazy);

    }
}

package org.ddestrei.p3.tasks;

import org.ddestrei.p3.mamy.Mama;
import org.ddestrei.p3.noworodki.Noworodek;

import java.util.Iterator;
import java.util.List;

public class First {
    private List<Mama> mamy;
    private List<Noworodek> noworodki;
    public First(List<Mama> mamy, List<Noworodek> noworodki){
        this.mamy=mamy;
        this.noworodki=noworodki;
    }
    public void task(){
        Noworodek najCh = null;
        Noworodek najDz = null;
        for (int i=0;i<noworodki.size();i++){
            Noworodek s = noworodki.get(i);
            if(s.getPlec().equals("s")){
                if(najCh==null){
                    najCh=s;
                }
                else {
                    if(najCh.getWzrost()<s.getWzrost()) najCh=s;
                }
            }
            else{
                if(najDz==null){
                    najDz=s;
                }
                else {
                    if(najDz.getWzrost()<s.getWzrost()) najDz=s;
                }
            }
        }
        System.out.println(najCh.toString());
        System.out.println(najDz.toString());
    }
}

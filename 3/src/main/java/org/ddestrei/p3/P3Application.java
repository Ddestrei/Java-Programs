package org.ddestrei.p3;

import org.ddestrei.p3.mamy.Mama;
import org.ddestrei.p3.mamy.MamaDao;
import org.ddestrei.p3.noworodki.Noworodek;
import org.ddestrei.p3.noworodki.NoworodekDao;
import org.ddestrei.p3.tasks.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.SealedObject;
import java.util.List;

@SpringBootApplication
public class P3Application {

	public static void main(String[] args) {
		SpringApplication.run(P3Application.class, args);
        MamaDao daoM = new MamaDao();
        NoworodekDao daoN = new NoworodekDao();
        List<Noworodek> noworodki = daoN.getNoworodki();
        //noworodki.forEach(s->System.out.println(s.toString()));
        List<Mama> mamy = daoM.getMamy();
        //mamy.forEach(s->System.out.println(s.toString()));
        System.out.println("");
        System.out.println("");
        System.out.println("");
        First f = new First(mamy, noworodki);
        f.task();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        Second s = new Second(mamy, noworodki);
        s.task();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        Third t = new Third(mamy,noworodki);
        t.task();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        Fourth fo = new Fourth(mamy,noworodki);
        fo.task();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        Fifth fi = new Fifth(mamy,noworodki);
        fi.task();

	}

}

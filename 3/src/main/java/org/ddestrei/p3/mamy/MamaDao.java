package org.ddestrei.p3.mamy;

import org.hibernate.Session;

import java.util.List;

public class MamaDao {
    public List<Mama> getMamy(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Mama", Mama.class).list();
        }
    }
}

package org.ddestrei.p3.noworodki;

import org.hibernate.Session;

import java.util.List;

public class NoworodekDao {
    public List<Noworodek> getNoworodki(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Noworodek", Noworodek.class).list();
        }
    }
}

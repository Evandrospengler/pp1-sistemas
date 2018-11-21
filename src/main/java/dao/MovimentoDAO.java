package dao;

import config.HibernateUtil;
import java.util.List;
import model.Movimento;
import org.hibernate.Session;

public class MovimentoDAO {

    private Session session;

    public MovimentoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(Movimento movimento) {
        session.getTransaction().begin();
        session.save(movimento);
        session.getTransaction().commit();
    }

    public void delete(Movimento movimento) {
        session.getTransaction().begin();
        session.remove(movimento);
        session.getTransaction().commit();
    }

    public List<Movimento> findAll() {
        return session.createQuery("select m from Movimento m").list();
    }

    public List<Movimento> findAllReceitas() {
        return session.createQuery("select m from Movimento m where m.valor > 0").list();
    }

    public List<Movimento> findAllDespesas() {
        return session.createQuery("select m from Movimento m where m.valor < 0").list();
    }
}

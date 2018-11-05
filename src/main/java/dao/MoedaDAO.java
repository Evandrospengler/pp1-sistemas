package dao;

import config.HibernateUtil;
import java.util.List;
import model.Moeda;
import org.hibernate.Session;

public class MoedaDAO {

    private Session session;

    public MoedaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void Inserir(Moeda o) {
        session.getTransaction().begin();
        session.save(o);
        session.getTransaction().commit();
    }

    public void Editar(Moeda o) {
        session.getTransaction().begin();
        session.update(o);
        session.getTransaction().commit();
    }

    public List<Moeda> ListarTodos() {
        List<Moeda> o = session.createQuery("select u from Moeda u").list();
        return o;
    }

    public void Excluir(Moeda u) {
        session.getTransaction().begin();
        session.delete(u);
        session.getTransaction().commit();
    }
}

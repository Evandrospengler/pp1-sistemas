package dao;

import config.HibernateUtil;
import java.util.List;
import model.Pessoa;
import org.hibernate.Session;


public class PessoaDAO {

    public static List<Pessoa> ListarTodos;

    private Session session;

    public PessoaDAO() {
        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void Inserir(Pessoa o) {
        session.getTransaction().begin();
        session.save(o);
        session.getTransaction().commit();
    }

    public void Editar(Pessoa o) {
        session.getTransaction().begin();
        session.update(o);
        session.getTransaction().commit();
    }

    public List<Pessoa> ListarTodos() {
        List<Pessoa> o = session.createQuery("select u from Pessoa u").list();
        return o;
    }

    public void Excluir(Pessoa u) {
        session.getTransaction().begin();
        session.delete(u);
        session.getTransaction().commit();
    }
}

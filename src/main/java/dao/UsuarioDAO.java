package dao;

import config.HibernateUtil;
import java.util.List;
import model.Usuario;
import org.hibernate.Session;

public class UsuarioDAO {

    private Session session;

    public UsuarioDAO() {
        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void Inserir(Usuario o) {
        session.getTransaction().begin();
        session.save(o);
        session.getTransaction().commit();
    }

    public void Editar(Usuario usuario) {
        session.getTransaction().begin();
        session.update(usuario);
        session.getTransaction().commit();
    }

    public List<Usuario> ListarTodos() {
        List<Usuario> usuarios = session.createQuery("select u from Usuario u").list();//session.createQuery("from suario as u").list();
        return usuarios;
    }

    public void Excluir(Usuario u) {
        session.getTransaction().begin();
        session.delete(u);
        session.getTransaction().commit();
    }
}

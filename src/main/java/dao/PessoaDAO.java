/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.HibernateUtil;
import java.util.List;
import model.Pessoa;
import org.hibernate.Session;

/**
 *
 * @author Anderson
 */
public class PessoaDAO {

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

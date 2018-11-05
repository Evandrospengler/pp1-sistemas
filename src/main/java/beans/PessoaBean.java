/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.PessoaDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Pessoa;

/**
 *
 * @author Anderson
 */
@Named(value = "pessoaBean")
@SessionScoped
public class PessoaBean implements Serializable {

    private PessoaDAO dao = new PessoaDAO();
    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> pessoas = new ArrayList<>();

    public PessoaBean() {
    }

    public void Salvar() {
        if (pessoa.getCodpessoa() > 0) {
            dao.Editar(pessoa);
        } else {
            dao.Inserir(pessoa);
        }
        pessoa = new Pessoa();
    }

    public void PreparaEdicao(Pessoa o) {
        this.pessoa = o;
    }

    public void Excluir(Pessoa o) {
        dao.Excluir(o);
    }

    public PessoaDAO getDao() {
        return dao;
    }

    public void setDao(PessoaDAO dao) {
        this.dao = dao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        pessoas = dao.ListarTodos();
        return dao.ListarTodos();
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

}

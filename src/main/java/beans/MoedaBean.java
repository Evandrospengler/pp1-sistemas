/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.MoedaDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import model.Moeda;

/**
 *
 * @author Anderson
 */
@Named(value = "moedaBean")
@SessionScoped
public class MoedaBean implements Serializable {

    private MoedaDAO dao = new MoedaDAO();
    private Moeda moeda = new Moeda();
    private List<Moeda> moedas = new ArrayList<>();

    public MoedaBean() {
    }

    public void Salvar() {
        if (moeda.getCodmoeda() > 0) {
            dao.Editar(moeda);
        } else {
            dao.Inserir(moeda);
        }
        moeda = new Moeda();
    }

    public MoedaDAO getDao() {
        return dao;
    }

    public void setDao(MoedaDAO dao) {
        this.dao = dao;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }

    public List<Moeda> getMoedas() {
        moedas = dao.ListarTodos();
        return dao.ListarTodos();
    }

    public void setMoedas(List<Moeda> moedas) {
        this.moedas = moedas;
    }

    public void PreparaEdicao(Moeda o) {
        this.moeda = o;
    }

    public void Excluir(Moeda o) {
        dao.Excluir(o);
        //return "userio";
    }
}

package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codmovimentacao;
    private Date dataprevista;
    private Date datarealizada;
    private double valor;
    private String historico;
    private int moeda;
    private int conta;
    private int pessoa;

    public int getCodmovimentacao() {
        return codmovimentacao;
    }

    public void setCodmovimentacao(int codmovimentacao) {
        this.codmovimentacao = codmovimentacao;
    }

    public Date getDataprevista() {
        return dataprevista;
    }

    public void setDataprevista(Date dataprevista) {
        this.dataprevista = dataprevista;
    }

    public Date getDatarealizada() {
        return datarealizada;
    }

    public void setDatarealizada(Date datarealizada) {
        this.datarealizada = datarealizada;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public int getMoeda() {
        return moeda;
    }

    public void setMoeda(int moeda) {
        this.moeda = moeda;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public int getPessoa() {
        return pessoa;
    }

    public void setPessoa(int pessoa) {
        this.pessoa = pessoa;
    }
}

package beans;

import dao.MovimentoDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Movimento;

@Named(value = "despesasBean")
@SessionScoped
public class DespesasBean implements Serializable {

    public DespesasBean() {
    }

    public void insertAction() {
        movimentoDAO.insert(movimento);
        this.movimento = new Movimento();
        this.movimentos = movimentoDAO.findAllDespesas();
    }

    public void atualizarAction() {
        this.movimentos = movimentoDAO.findAllDespesas();
    }

    public void selectItem(Movimento mov) {
        this.movimento = mov;
    }

    public void limpaForm() {
        this.movimento = new Movimento();
    }

    public void removeAction(Movimento mov) {
        movimentoDAO.delete(mov);
        this.movimentos = movimentoDAO.findAllDespesas();
    }

    private MovimentoDAO movimentoDAO = new MovimentoDAO();

    private Movimento movimento = new Movimento();
    private List<Movimento> movimentos = new ArrayList<>();

    public Movimento getMovimento() {
        return movimento;
    }

    public void setMovimento(Movimento movimento) {
        this.movimento = movimento;
    }

    public List<Movimento> getMovimentos() {
        if (this.movimentos == null) {
            this.movimentos = movimentoDAO.findAllDespesas();
        }
        return movimentos;
    }

    public void setMovimentos(List<Movimento> movimentos) {
        this.movimentos = movimentos;
    }

}

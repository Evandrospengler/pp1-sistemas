
package beans;

import config.ReportUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.Dependent;


@Named(value = "fluxodeCaixaBean")
@Dependent
public class FluxodeCaixaBean {

    private Date dataInicial;
    private Date dataFinal;
    
    public FluxodeCaixaBean() {
    }
    public void gerarRelatorio(){
        ReportUtil r1 = new ReportUtil(); 
        Map parametros = new HashMap();
        parametros.put("dataInicial" , dataInicial);
        parametros.put("dataFinal", dataFinal);
        r1.imprimirRelatorio("FluxodeCaixa", parametros);
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
}

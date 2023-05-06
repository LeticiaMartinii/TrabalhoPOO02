import java.time.LocalDate;
import java.util.List;

public class Gastos {
    private String nome ;
    private TipoGastos tipo;
    private FormPagam formaPag;
    
    private void setNome(String n){
        this.nome = n;
    }
    
    private void setTipo(int t, LocalDate d){
        TipoGastos tipoGasto = new TipoGastos(t,d);
        this.tipo = tipoGasto;
    }
    
    private void setForma(int f, double v){
        FormPagam formaPagamento = new FormPagam(f,v);
        this.formaPag = formaPagamento;
    }
    
    public Gastos(String n,int t, LocalDate d, int f, double v){
        this.setNome(n);
        this.setTipo(t,d);
        this.setForma(f,v);   
    }
 
    public String getNome() {
        return nome;
    }

    public TipoGastos getTipo() {
        return tipo;
    }

    public FormPagam getFormaPag() {
        return formaPag;
    }

    @Override
    public String toString() {
        return "Gasto{" + "nome=" + nome + ", tipo=" + tipo + ", formaPag=" + formaPag + '}';
    }
    
    public double buscarGastosMesAno(List<Gastos> listaGastos, LocalDate data) {
    double totalGastos = 0.0;
    for (Gastos g : listaGastos) {
        LocalDate dataGasto = g.getTipo().getData();
            if (dataGasto.getMonth() == data.getMonth() && dataGasto.getYear() == data.getYear()) {
                totalGastos += g.getFormaPag().getValor();
            }
        }
        return totalGastos;
    }
    
}

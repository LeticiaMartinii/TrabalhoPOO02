import java.time.LocalDate;
import java.util.List;

public class Ganhos {
    private String nome;
    private TipoGanhos tipo;
    private LocalDate data;
    
    private void setNome(String n){
        this.nome = n;
    }
    
    private void setTipo(int t, double v){
        TipoGanhos tipoDeGanho = new TipoGanhos(t,v);
        this.tipo = tipoDeGanho;
    }
    
    private void setData(LocalDate d){
        this.data = d;
    }
    
    public Ganhos(String n, int t, double v, LocalDate d){
        this.setNome(n);
        this.setTipo(t,v);
        this.setData(d);
    }

    public String getNome() {
        return nome;
    }

    public TipoGanhos getTipo() {
        return tipo;
    }

    public LocalDate getData() {
        return data;
    }
    
    public double buscarGanhosMesAno(List<Ganhos> listaGanhos, LocalDate data) {
    double totalGastos = 0.0;
    for (Ganhos g : listaGanhos) {
        LocalDate dataGasto = g.getData();
            if (dataGasto.getMonth() == data.getMonth() && dataGasto.getYear() == data.getYear()) {
                totalGastos += g.getTipo().getValor();
            }
        }
        return totalGastos;
    }
    
    
}

import java.time.LocalDate;

public class TipoGastos {
    private String nome;
    private LocalDate data;

    private void setNome(String n){
        this.nome = n;
    }

    private void setData(LocalDate d){
        this.data = d;
    }
    public TipoGastos(int t, LocalDate d){
        switch (t){
            case 1 -> this.setNome("Habitacao");
            case 2 -> this.setNome("Entretenimento");
            case 3 -> this.setNome("Alimentacao");
            case 4 -> this.setNome("Transporte");
            default -> this.setNome("Outros gastos"); 
        }
        this.setData(d);
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData() {
        return data;
    }

   
    
}
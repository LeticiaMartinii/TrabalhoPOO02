public class TipoGanhos {
    private String nome;
    private double valor;
    
    private void setNome(String n){
        this.nome = n;
    }
    
    private void setValor(double v){
        this.valor = v;
    }
    
    public TipoGanhos(int t, double v){
        switch(t){
            case 1->this.setNome("salario");
            case 2->this.setNome("freelancer");
            case 3->this.setNome("Dividendos");
            default->this.setNome("Outros");
        }
        this.setValor(v);
    } 

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
    
}
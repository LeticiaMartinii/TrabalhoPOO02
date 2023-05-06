public class FormPagam {
    private String nome;
    private double valor;
    
    private void setDesc(String n){
        this.nome = n;
    }
    
    private void setValor(double v){
        this.valor = v;
    }
    
    public FormPagam(int f, double v){
        switch(f){
            case 1 -> this.setDesc("Cheque");
            case 2 -> this.setDesc("Pix");
            case 3 -> this.setDesc("Débito");
            default-> this.setDesc("Outras");
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

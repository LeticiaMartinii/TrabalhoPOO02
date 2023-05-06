import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Gastos> listaGastos = new ArrayList<>();
        List<Ganhos> listaGanhos = new ArrayList<>();
        List<Gastos> filtroData = new ArrayList<>();
        Gastos novoGasto = null;
        Ganhos novoGanho = null;
        System.out.println("Ola usuario, abaixo estao descritas opcoes para lhe auxiliar na sua gestao financeira");
        System.out.println("-----------------");
        System.out.println("1 - Adcionar gasto");
        System.out.println("2 - Adcionar ganho");
        System.out.println("3 - Relatorio de gastos");
        System.out.println("4 - Relatorio de ganhos");
        System.out.println("5 - Relatorio mensal");
        System.out.println("6 - Sair");
      
        Scanner enter = new Scanner(System.in);
        int opcao = enter.nextInt();
        enter.nextLine();
        switch (opcao){
            case 1:
                System.out.println("Adicionar Gasto");
                System.out.println("---------------");
                System.out.println("1 - Habitacao");
                System.out.println("2 - Entretenimento");
                System.out.println("3 - Alimentacao");
                System.out.println("4 - Transporte");
                System.out.println("5 - Outros gastos");
                System.out.println("6 - voltar");

                int t = enter.nextInt();
                enter.nextLine();
                if(t > 0 && t < 6 ){
                    System.out.println("Adicionar Gasto");
                    System.out.println("---------------");
                    System.out.print("Digite a data no formato dd MM yyyy(separado por espacos), exemplo 05 05 2023, agora é a sua vez: ");
                    
                    int diaGastos = enter.nextInt();
                    int mesGastos = enter.nextInt();
                    int anoGasto = enter.nextInt();
                    LocalDate dataGastos = LocalDate.of(anoGasto, mesGastos, diaGastos);
                    System.out.println(dataGastos);
             
                    System.out.print("Informe o valor: ");
                    double v = enter.nextDouble();
                    System.out.println("Selecione a forma de pagamento!");
                    System.out.println("-------------------------------");
                    System.out.println("1 - Cheque");
                    System.out.println("2 - Pix");
                    System.out.println("3 - Debito");
                    System.out.println("4 - Outras");
                    int f = enter.nextInt();
                    
                    if (f <= 0 || f > 4){
                        limparConsole();
                        System.out.println("Digite uma das opções oferecidas!");
                        main(new String[]{"Voltar"});
                    }else{
                        System.out.println("Digite o nome do gasto(ex:Celesc): ");
                        String n = enter.nextLine();
                    
                        novoGasto = new Gastos(n,t,dataGastos,f,v);
                        listaGastos.add(novoGasto);
                        limparConsole();
                        main(new String[]{"Voltar"});
                    } 
                }
                if (t == 6){
                    limparConsole();
                    System.out.println("VOLTANDO..");
                    main(new String[]{"Voltar"});
                }
                else if (t > 6 || t <= 0){
                    limparConsole();
                    System.out.println("Digite uma opcao valida!");
                    System.out.println("VOLTANDO..");
                    main(new String[]{"Voltar"});
                }
                break;
            case 2:
                System.out.println("Adicionar Ganho");
                System.out.println("---------------");
                System.out.println("1 - salario");
                System.out.println("2 - freelancer");
                System.out.println("3 - Dividendos");
                System.out.println("4 - Outros");
                System.out.println("5 - voltar");
                
                int tGanho = enter.nextInt();
                enter.nextLine();
                if (tGanho > 0 && tGanho < 5){
                    System.out.println("Adicionar Ganho");
                    System.out.println("---------------");
                    System.out.print("Digite a data no formato dd MM yyyy(separado por espacos): ");
                    
                    int diaGanho = enter.nextInt();
                    int mesGanho = enter.nextInt();
                    int anoGanho = enter.nextInt();
                    LocalDate dataGan = LocalDate.of(anoGanho, mesGanho, diaGanho);
                    System.out.println(dataGan);
                
                    System.out.print("Digite a origem(ex:ProjetoA): ");
                    String nGanho = enter.nextLine();
                    
                    System.out.println("Digite o valor do ganho:");
                    int vGanho = enter.nextInt();
                    enter.nextLine();
                    
                    novoGanho = new Ganhos(nGanho, tGanho, vGanho,dataGan);
                    listaGanhos.add(novoGanho);
                    limparConsole();
                    main(new String[]{"Voltar"});
                }
                if (tGanho == 5){
                    limparConsole();
                    System.out.println("VOLTANDO..");
                    main(new String[]{"Voltar"});
                }
                else if (tGanho > 6 || tGanho <= 0){
                    limparConsole();
                    System.out.println("Digite uma opcao valida!");
                    System.out.println("VOLTANDO..");
                    main(new String[]{"Voltar"});
                }
                break;
            case 3:
                System.out.println("Relatorio de gastos");
                System.out.println("------------------");
                System.out.print("Digite o mes (1-12) e o ano (yyyy) separados por um espaco: ");
                
                int mes = enter.nextInt();
                int ano = enter.nextInt();
                int dia = 1;
                LocalDate data = LocalDate.of(ano, mes, dia);

                double totalGasto = novoGasto.buscarGastosMesAno(listaGastos, data);
                System.out.println("Relatorio de gastos");
                System.out.println("------------------");
                System.out.println("Total de gastos do periodo selecionado: "+ totalGasto);
                break;
            case 4:
                System.out.println("Relatorio de ganhos");
                System.out.println("------------------");
                System.out.print("Digite o mes (01 a 12) e o ano (yyyy) separados por um espaco, exemplo: 05 2023, agora é a sua vez: ");
                
                int mesGan = enter.nextInt();
                int anoGan = enter.nextInt();
                int diaGan = 1;
                LocalDate dataGan = LocalDate.of(anoGan, mesGan, diaGan);

                double totalGanho = novoGanho.buscarGanhosMesAno(listaGanhos, dataGan);
                System.out.println("Relatorio de ganhos");
                System.out.println("------------------");
                System.out.println("Total de ganhos do periodo selecionado: "+ totalGanho);
                break;
            case 5:
                System.out.println("Relatorio mensal");
                System.out.println("----------------");
                System.out.print("Digite o mes (01 a 12) e o ano (yyyy) separados por um espaco, exemplo: 05 2023, agora é a sua vez: ");
                
                int mesRe = enter.nextInt();
                int anoRe = enter.nextInt();
                int diaRe = 1;
                LocalDate dataRelatorio = LocalDate.of(anoRe, mesRe, diaRe);
                double totalGanhoRelatorio = novoGanho.buscarGanhosMesAno(listaGanhos, dataRelatorio);
                double totalGastosRelatorio = novoGanho.buscarGanhosMesAno(listaGanhos, dataRelatorio);
                double saldo = totalGanhoRelatorio - totalGastosRelatorio;
                System.out.println("Relatorio do periodo");
                System.out.println("--------------------");
                System.out.println("Total de ganhos do periodo: "+ totalGanhoRelatorio);
                System.out.println("Total de gastos do periodo: "+ totalGastosRelatorio);
                System.out.println("Saldo: "+ saldo);
                break;
            case 6:
                break;
            default:
                limparConsole();
                    System.out.println("Digite uma opcao valida!");
                    System.out.println("VOLTANDO..");
                    main(new String[]{"Voltar"});
        }
    }

    public static void limparConsole() {
    try {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_L);
    } 
    catch (Exception e) {
        main(new String[]{"Voltar"});
    }
}
}


import java.util.Scanner;

public class Principal{
    public static void main(String args[]){
        Scanner entrada = new Scanner(System.in);
        String lixo = entrada.nextLine();
        String estados = entrada.nextLine();
        String alfabetoEntrada = entrada.nextLine();
        String alfabetoFita = entrada.nextLine();
        lixo = entrada.nextLine();
        Maquina m = new Maquina();
        ManipulaString.insereEstados(estados,m);
        ManipulaString.insereAlfabetoEntrada(alfabetoEntrada, m);
        ManipulaString.insereAlfabetoFita(alfabetoFita,m);
        String transicao = entrada.nextLine();
        while(!transicao.equals("}")){
            ManipulaString.insereTransicao(transicao,m);
            transicao = entrada.nextLine();
        }
        String estadoInicial = entrada.nextLine();
        ManipulaString.insereEstadoInicial(estadoInicial,m);
        lixo = entrada.nextLine();
        String fita = entrada.nextLine();
        m.setFita(fita);
        m.escreverMaquina();
    }

}